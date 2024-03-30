package com.casefy.service.Lote;

import java.util.Date;
import java.util.List;

import com.casefy.dto.Lote.LoteDto;
import com.casefy.dto.Lote.LoteResponseDto;

public interface LoteService {

    public LoteResponseDto insert(LoteDto dto);

    public LoteResponseDto update(LoteDto dto, Long id);

    public void delete(Long id);

    public LoteResponseDto findById(Long id);

    public List<LoteResponseDto> findByData(Date data);

    public List<LoteResponseDto> findByAll();
}
