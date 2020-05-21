package es.um.asio.inputprocessor.service.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.um.asio.abstractions.domain.ExitStatusCode;
import es.um.asio.abstractions.domain.JobType;
import es.um.asio.abstractions.filter.AbstractJpaSpecification;
import es.um.asio.abstractions.filter.EntityFilter;
import es.um.asio.domain.importResult.ImportResult;
import es.um.asio.domain.importResult.ImportResult_;
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
     * JobType
     */
    private JobType jobType;
    
    /**
     *  ExitStatusCode
    */
    private ExitStatusCode exitStatusCode;
 
    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate toPredicate(final Root<ImportResult> root, final CriteriaQuery<?> query,
            final CriteriaBuilder criteriaBuilder) {

        final List<Predicate> predicates = new ArrayList<>();

        if (this.jobType != null) {
            predicates.add(this.createEquals(root, criteriaBuilder, ImportResult_.JOB_TYPE, this.jobType));
        }
        
        if (this.exitStatusCode != null) {
            predicates.add(this.createEquals(root, criteriaBuilder, ImportResult_.EXIT_STATUS_CODE, this.exitStatusCode));
        }
       
        return criteriaBuilder.and(predicates.stream().toArray(Predicate[]::new));
    }
}
