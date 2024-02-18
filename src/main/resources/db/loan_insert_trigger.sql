
CREATE TRIGGER loan_insert_trigger
BEFORE INSERT ON loan
FOR EACH ROW
BEGIN

rate_value character;

    SELECT variable_interest_rate into rate_value from loan_product_types ;

    if variable_interest_rate = "Y" then
       NEW.rate = 5.25;
    end if;

    UPDATE employee
    SET last_updated = NOW()
    WHERE id = NEW.id;
END ;
