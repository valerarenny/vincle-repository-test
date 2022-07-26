CREATE TABLE IF NOT EXISTS items.capacity (
	id SERIAL NOT null,
	amount numeric(19, 2) NULL,
	description varchar(255) NULL,
	units varchar(255) NULL,
	CONSTRAINT capacity_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS items.packaging (
	id SERIAL NOT NULL,
	description varchar(255) NULL,
	"type" varchar(255) NULL,
	CONSTRAINT packaging_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS items.item_capacity (
	item_id int4 NOT NULL,
	capacity_id int4 NOT NULL,
	CONSTRAINT item_capacity_pkey PRIMARY KEY (item_id, capacity_id)
);

CREATE TABLE IF NOT EXISTS items.item_packaging (
	item_id int4 NOT NULL,
	packaging_id int4 NOT NULL,
	CONSTRAINT item_packaging_pkey PRIMARY KEY (item_id, packaging_id)
);

CREATE TABLE IF NOT EXISTS items.item (
	id SERIAL NOT NULL,
	client_id varchar(255) NULL,
	cooling bool NULL,
	created timestamp NULL,
	deleted timestamp NULL,
	"name" varchar(255) NULL,
	status varchar(255) NULL,
	updated timestamp NULL,
	CONSTRAINT item_pkey PRIMARY KEY (id)
);