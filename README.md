# Design-Patterns
Object Orientation with Design Patterns CA

-Singleton Lazy Instantiation
Used for database connection and access to printing options (menu) class. This pattern was chosen beacuse of the creation of the instance  ONLY when it is required, at runtime. 
Using this creational pattern means the same instance will be reused when the access is required, which means memory saving.

-Builer Pattern
Used for Object Country creation. A Country is a complex object that take 5 parameters in. Once 2 of them have a default value predefined on the database, therefore, they could be considered optional and its default value could be set. 
Using the builder pattern require that the object receives the main parameters in and the optional parameters are add via builder, which is an advantage should more parameters be added to the object.
