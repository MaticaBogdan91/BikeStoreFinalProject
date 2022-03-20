# BikeStoreProject CRUD Operations Java + Spring + Hibernate + PostMan
Spring Crud Operations + Front End Simulator: PostMan.
In this project you can make CRUD operations with Spring, on each bike or bike accessory, using the front-end simulator PostMan at//localhost:8080.

It is directly connected with database MySQL from where you can bring something from the database, create, delete, update directly from PostMan.

In the project, I used DTO to be sure that the user receives only the information that a usual User it's allowed to receive, and I used Mapper's to Map things from Entity to DTO and from DTO to Entity.

I used Repository from his benefits, but the best benefit I found it's that it extends CrudRepository.

In the Controller I used logger.info, and here we can make all the CRUD operations simple and very clear.

