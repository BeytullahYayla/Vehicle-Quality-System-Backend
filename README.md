# Car Vehicle Quality System

Car Vehicle Quality System is a project that provides a platform for the quality control and tracking of vehicles. This project aims to be a useful tool for vehicle manufacturers, sellers, or quality control departments. The system is developed to ensure the management of vehicles in compliance with quality standards at all stages (production, delivery, sales).

## Features

- User management: Users can log in to the system, manage vehicles, and report defects.
- Vehicle management: Vehicles can be added, updated, deleted, and queried using search filters.
- Defect management: Users can report defects in vehicles and manage the handling of these defects.


## Requirements

- Java 8 or newer version
- Maven 3 or newer version
- PostgreSQL database

## Installation

1. Clone this repository: `git clone https://github.com/BeytullahYayla/CarVehicleQualitySystem.git`
2. Install and configure PostgreSQL database.
3. Open the `application.properties` file and update the database connection settings.
4. Run the following command in the project folder: `mvn clean install`
5. Start the application by running the following command: `mvn spring-boot:run`

## Usage

- After the application is successfully running, go to http://localhost:8080.
- Log in with your username and password.
- Add, update, and delete vehicles.
- Report and manage defects.
- Generate statistical reports and perform analysis.

## Contributing

1. Fork this repository.
2. Create a new branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin feature/your-feature-name`
5. Submit a Pull Request.

