# Poke Guide
Welcome to Poke Guide! This is a simple Android application developed in Kotlin using Jetpack Compose that serves as a Pokedex. The main objective of this project is to demonstrate basic Android development skills, including API consumption, local data storage, and a simple user interface.
## Features
* Pokemon Listing: Fetches a list of Pokemon from a public API and displays them in a list.
* Search Functionality: Allows users to search for specific Pokemon by name.
* Favorites: Users can add their favorite Pokemon to a local favorites list using Room database.

## Screenshots
## Architecture
The project follows the MVVM (Model-View-ViewModel) architecture pattern to separate the concerns of the application and make it more maintainable.
## Libraries Used
* Retrofit: For API calls.
* Room: For local database storage.
* Jetpack Compose: For modern UI development.
* ViewModel: For managing UI-related data in a lifecycle-conscious way.
* Kotlin Coroutines: For background tasks.
## Getting Started
1. Clone the repository
   
```git clone https://github.com/yourusername/poke-guide.git```

2. Clone the repository
   
Open Android Studio and select File -> Open, then navigate to the directory where you cloned the repository.

3. Build the project

Once the project is open in Android Studio, let it sync and build the necessary dependencies.

4. Run the app

Connect your Android device or start an emulator and run the app by clicking the 'Run' button.
## API
This project uses the [PokeApi](https://pokeapi.co/) to fetch Pokemon data.

## Room Database
The Room database is used to store the user's favorite Pokemon locally. The database consists of a single table:

* Pokemon: Stores the informations of the favorite Pokemon.
## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
