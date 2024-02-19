CREATE OR REPLACE FUNCTION update_rate()
RETURNS TRIGGER AS $$
BEGIN
  SELECT variable_interest_rate into rate_value from loan_product_types ;

    if variable_interest_rate = "Y" then
       NEW.rate = 5.25;
    end if;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER loan_insert_trigger
BEFORE UPDATE ON loan
FOR EACH ROW
EXECUTE FUNCTION update_rate();
