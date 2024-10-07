package net.mephys.arkheion.catalog.exception;

public class CatalogItemNotFoundException extends RuntimeException {
    public CatalogItemNotFoundException(Integer id) {
        super("Catalog Item not found with ID: " + id);
    }
}
