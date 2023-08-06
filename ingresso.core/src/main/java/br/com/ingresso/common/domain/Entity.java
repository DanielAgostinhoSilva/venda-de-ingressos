package br.com.ingresso.common.domain;

import br.com.ingresso.common.domain.value.object.Id;

import java.util.Objects;

public abstract class Entity {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(this.getId(), entity.getId());
    }

    public abstract Id getId();
}
