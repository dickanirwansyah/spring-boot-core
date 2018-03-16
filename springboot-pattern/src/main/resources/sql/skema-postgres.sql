create table category(
    idcategory varchar(255) not null unique,
    name varchar(255) not null,
    description varchar(255) not null,

    CONSTRAINT pk_category_idcategory PRIMARY KEY (idcategory)
);

create table product(
    idproduct varchar(255) not null unique,
    name varchar(255) not null,
    quantity int not null,
    price decimal(12,2) not null,
    idcategory varchar(255) not null,

    CONSTRAINT pk_product_idproduct PRIMARY KEY (idproduct),
    CONSTRAINT fk_product_idcategory FOREIGN KEY (idcategory)
    REFERENCES category(idcategory)
);