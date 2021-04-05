package utilities.adapters;

import managers.DatabaseManager;
import models.dtos.CartItemDto;
import models.orm.CartItem;
import net.jodah.typetools.TypeResolver;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class GenericAdapter<T, R> {
    public abstract R copyOrmToDto(T orm);

    private List<R> copyOrmToDto(List<T> orms) {
        return orms.stream().map(this::copyOrmToDto).collect(Collectors.toList());
    }
}
