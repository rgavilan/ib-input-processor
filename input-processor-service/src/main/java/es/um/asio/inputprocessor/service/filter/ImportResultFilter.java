package es.um.asio.inputprocessor.service.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.izertis.abstractions.filter.AbstractJpaSpecification;
import com.izertis.abstractions.filter.EntityFilter;

import es.um.asio.domain.importResult.ImportResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Filter for {@link ImportResult}.
 */
@Getter
@Setter
@NoArgsConstructor
public class ImportResultFilter extends AbstractJpaSpecification<ImportResult> implements EntityFilter {

    /**
     * Version ID.
     */
    private static final long serialVersionUID = 6371198455272564828L;

 
    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate toPredicate(final Root<ImportResult> root, final CriteriaQuery<?> query,
            final CriteriaBuilder criteriaBuilder) {

        final List<Predicate> predicates = new ArrayList<>();

       
        return criteriaBuilder.and(predicates.stream().toArray(Predicate[]::new));
    }
}
