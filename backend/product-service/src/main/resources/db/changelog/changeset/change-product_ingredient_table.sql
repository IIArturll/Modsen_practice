alter table modsen.product_ingredient
    drop column weight;

alter table modsen.product_ingredient
    drop column ingredient_id;

alter table modsen.product_ingredient
    add ingredient_model_id integer;

alter table modsen.product_ingredient
    add constraint product_ingredient_ingredient_model_fk
        foreign key (ingredient_model_id) references modsen.ingredient_model(id);