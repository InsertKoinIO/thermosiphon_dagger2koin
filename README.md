# The thermosiphon app - from Dagger to Koin step by step

This project shows how to migrate the thermosiphon Dagger's sample to Koin, step by step.

## The article

This project has been explained in detail from the article: []()

## Gradle 

To build the project (Dagger generation), just hit the following command:

```gradle
./gradlew clean build
```

## Migration step by step

Below the git *tags* of the project, to follow the migration steps:

* DAGGER - init commit with app managed by Dagger
* STEP1 - `Heater` component migrated
* STEP2 - `Pump` component migrated
* KOIN - `CoffeeMaker` component migrated
