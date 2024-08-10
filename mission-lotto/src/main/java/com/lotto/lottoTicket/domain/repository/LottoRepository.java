package com.lotto.lottoTicket.domain.repository;

import com.lotto.lottoTicket.domain.entity.Lotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LottoRepository extends JpaRepository<Lotto, Long> {

}
