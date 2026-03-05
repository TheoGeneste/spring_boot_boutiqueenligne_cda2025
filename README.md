## Projet Boutique – Application Spring Boot

Ce projet est une **API REST de boutique en ligne** développée avec **Spring Boot**.  
Elle permet de gérer des **clients**, **produits**, **commandes**, **paiements** et les relations entre ces éléments (par exemple, un produit appartient à une catégorie).

L’objectif principal est pédagogique : **illustrer une architecture propre en couches** avec controllers, services, repositories, entités, DTOs, mappers et configuration.

---

## 1. Architecture globale

Le code est organisé par **packages fonctionnels** :

- **`config`** : configuration technique de l’application (sécurité, etc.).
- **`controllers`** : couches web / exposition des **endpoints REST**.
- **`dtos`** : **DTOs (Data Transfer Objects)** utilisés pour échanger des données avec le client HTTP.
- **`entites`** : entités JPA, **modèle métier** persistant en base de données.
- **`mappers`** : mappers MapStruct pour convertir **Entités ⇔ DTOs**.
- **`repositories`** : accès aux données via **Spring Data JPA**.
- **`services`** : logique métier et orchestration entre repository / mapper / contrôleur.

Le flux général est :

Client HTTP → `controllers` → `services` → `mappers` → `entites` → `repositories` → Base de données  
… puis dans l’autre sens pour renvoyer une réponse (entités → mappers → DTOs → controller → client).

---

## 2. Détail des couches (exemples avec Appartenir)

Pour mieux comprendre, on s’appuie sur le cas de la relation **`Appartenir`** (un produit appartient à une catégorie).

### 2.1 Controllers (`controllers`)

Exemple : `AppartenirController`

- Annotations importantes :
  - **`@RestController`** : indique que la classe expose des endpoints REST et renvoie directement du JSON.
  - **`@RequestMapping("/api/appartenirs")`** : définit le **préfixe d’URL** pour tous les endpoints du contrôleur.
  - **`@GetMapping`**, **`@PostMapping`**, **`@DeleteMapping`** : associent les **méthodes HTTP** aux méthodes Java.
  - **`@PathVariable`** : récupère les variables de chemin dans l’URL (ex : `/api/appartenirs/{produitId}/{categorieId}`).
  - **`@RequestBody`** : lit le **JSON** du corps de la requête et le convertit en objet Java (DTO).

**Rôle global :**

- C’est la couche **la plus proche du client HTTP** (Postman, front, etc.).
- Elle **ne contient pas la logique métier** : elle **délègue** tout au `service`.
- Elle traduit :
  - la requête HTTP → **appel de méthode de service**,
  - la réponse du service → **JSON** renvoyé au client.

### 2.2 Services (`services`)

Exemple : `AppartenirService`

- Annotations importantes :
  - **`@Service`** : classe métier Spring, gérée comme un bean.
  - **`@RequiredArgsConstructor`** (Lombok) : génère un constructeur avec les champs `final` pour l’injection.

**Rôle global :**

- Contient la **logique métier** (et éventuellement des règles métier).
- **Orchestre** :
  - les appels aux `repositories` (accès BDD),
  - l’utilisation des `mappers` pour convertir **Entités ⇔ DTOs**.
- Exemple de méthodes :
  - `findAll()` : récupère toutes les entités via le repository, puis les convertit en DTOs avec le mapper.
  - `find(produitId, categorieId)` : construit la clé composite `AppartenirID`, cherche en BDD, renvoie un DTO.
  - `save(AppartenirRequestDTO dto)` : convertit le DTO en entité, puis appelle `save()` du repository.
  - `remove(produitId, categorieId)` : crée la clé composite et appelle `deleteById()` du repository.

### 2.3 Repositories (`repositories`)

Exemple : `AppartenirRepository`

- Annotations importantes :
  - **`@Repository`** : indique une couche d’accès aux données.
  - **`extends JpaRepository<Appartenir, AppartenirID>`** :
    - `Appartenir` : type de l’entité.
    - `AppartenirID` : type de la **clé primaire** (ici composite).

**Rôle global :**

- Fournit des méthodes de **CRUD** automatiques :
  - `findAll()`, `findById(id)`, `save(entity)`, `deleteById(id)`, etc.
- On écrit surtout **l’interface**, pas l’implémentation : Spring Data JPA génère tout.
- C’est l’unique couche qui **parle directement à la base de données**.

### 2.4 Entités (`entites`)

Exemples : `Appartenir`, `AppartenirID`, `Client`, `Produit`, etc.

- Annotations importantes :
  - **`@Entity`** : classe mappée à une **table** de la base.
  - **`@Table(name = "...")`** : nom de la table.
  - **`@Id`**, **`@GeneratedValue`**, **`@Column`** : configuration des colonnes et clés primaires simples.
  - **`@EmbeddedId`**, **`@Embeddable`** : gestion des **clés primaires composites** (ex : `Appartenir`).
  - **`@ManyToOne`**, **`@OneToMany`**, **`@JoinColumn`**, **`@MapsId`** : gestion des **relations** (Foreign Keys).
  - Lombok : **`@Getter`**, **`@Setter`**, etc. pour générer automatiquement le boilerplate.

**Rôle global :**

- Représentent le **modèle métier** persistant :
  - ce sont les **objets manipulés par JPA/Hibernate**,
  - chaque instance correspond à une **ligne** dans une table.
- Dans le cas de `Appartenir` :
  - `AppartenirID` (clé composite) avec `produitId` et `categorieId`.
  - Relations `ManyToOne` vers `Produit` et `Categorie`.

### 2.5 DTOs (`dtos`)

Exemples : `AppartenirRequestDTO`, `AppartenirResponseDTO`, `ClientDTO`, etc.

- Souvent écrits sous forme de **`record` Java** (immuables, concis).
- Distinction typique :
  - **Request DTO** : ce que **le client envoie** (POST/PUT).
  - **Response DTO** : ce que **l’API renvoie** (GET).

**Rôle global :**

- Séparer le **modèle exposé au client** du modèle interne (entités).
- Permettre :
  - de **cacher** certains champs (ex : mots de passe, IDs internes),
  - d’**adapter** la structure renvoyée (agrégations, projections, etc.),
  - de garder l’API **stable** même si la base évolue.

Pour `Appartenir` :

- `AppartenirRequestDTO` : contient le produit et la catégorie à associer.
- `AppartenirResponseDTO` : contient en plus l’`AppartenirID` (clé composite).

### 2.6 Mappers (`mappers`)

Exemple : `AppartenirMapper`, `ClientMapper`, `ProduitMapper`, etc.

- Annotation importante :
  - **`@Mapper(componentModel = "spring")`** : interface MapStruct, Spring génère un **bean** automatiquement.

**Rôle global :**

- Centraliser toute la logique de **conversion** :
  - Entité → DTO (pour les réponses),
  - DTO → Entité (pour les requêtes).
- Évite de répéter du code de mapping dans les controllers ou services.
- Le code est **généré** par MapStruct en se basant sur les signatures :
  - `AppartenirResponseDTO toDTO(Appartenir appartenir);`
  - `Appartenir toEntity(AppartenirRequestDTO dto);`

### 2.7 Configuration (`config`)

Exemple : `SecurityConfig`

- Annotations importantes :
  - **`@Configuration`** : classe de configuration Spring (déclare des beans).
  - **`@Bean`** : méthode qui crée un bean géré par Spring.

**Rôle global :**

- Configurer les aspects **techniques** de l’application :
  - ici, la **sécurité Spring Security** (`SecurityFilterChain`).
- Dans la version actuelle :
  - `csrf` est désactivé,
  - `anyRequest().permitAll()` : **toutes les requêtes sont autorisées** (utile pour le développement/démo).

---

## 3. Lancer le projet

### 3.1 Prérequis

- **Java 17** (ou version compatible avec le `pom.xml`).
- **Maven** installé (ou utilisation de `mvnw` sous Windows/Linux).
- Une base de données **MySQL** avec les paramètres définis dans `src/main/resources/application.properties` :
  - URL, utilisateur, mot de passe, nom de base (`boutiqueenligne`).

### 3.2 Commandes

Depuis la racine du projet :

```bash
mvn spring-boot:run
```

ou en générant le JAR :

```bash
mvn clean package
java -jar target/boutique-*.jar
```

L’application démarre par défaut sur `http://localhost:8080`.

---

## 4. Exemple d’utilisation de l’API (cas Appartenir)

- **Lister toutes les relations produit-catégorie**  
  - `GET /api/appartenirs`

- **Récupérer une relation précise**  
  - `GET /api/appartenirs/{produitId}/{categorieId}`

- **Créer une nouvelle relation**  
  - `POST /api/appartenirs`  
  - Corps JSON correspondant à `AppartenirRequestDTO`

- **Supprimer une relation**  
  - `DELETE /api/appartenirs/{produitId}/{categorieId}`

---

## 5. Résumé pédagogique

- Les **controllers** gèrent les **requêtes HTTP** et renvoient des **DTOs**.
- Les **services** portent la **logique métier** et orchestrent les couches.
- Les **repositories** fournissent les opérations **CRUD** sur les entités.
- Les **entités** représentent les **tables** et les **relations** de la BDD.
- Les **DTOs** sont des **modèles d’échange** entre l’API et le client.
- Les **mappers** automatisent la **conversion** Entité ⇔ DTO.
- La **config** (`SecurityConfig`) gère la **sécurité** et la configuration technique.

Ce découpage permet une application **claire**, **testable**, **évolutive** et facile à maintenir.


