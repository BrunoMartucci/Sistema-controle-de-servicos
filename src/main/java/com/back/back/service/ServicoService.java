package com.back.back.service;

import com.back.back.entity.Servico;
import com.back.back.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> buscarTodos(){
        return servicoRepository.findAll();
    }

    public Servico inserir(Servico servico){
        if (servico.getValorPago()==null || servico.getValorPago()==0 || servico.getDataPagamento()==null){
            servico.setStatus("pendente");
        }else{
            servico.setStatus("realizado");
        }
        return servicoRepository.saveAndFlush(servico);
    }

    public Servico alterar(Servico servico){
        if(servico.getValorPago()!=null && servico.getValorPago()>0 && servico.getDataPagamento()!=null){
            servico.setStatus("realizado");
        }
        return servicoRepository.saveAndFlush(servico);
    }

    public void cancelarServico(Long id){
        Servico servico = servicoRepository.findById(id).get();
        servico.setStatus("cancelado");
        servicoRepository.save(servico);
    }

    public void excluir(Long id){
        Servico servico = servicoRepository.findById(id).get();
        servicoRepository.delete(servico);
    }

    public List<Servico> buscarServicosPagamentoPedente(){
        return servicoRepository.buscarServicosPagamentoPedente();
    }

    public List<Servico> buscarServicosCancelado(){
        return servicoRepository.buscarServicosCancelado();
    }

}
