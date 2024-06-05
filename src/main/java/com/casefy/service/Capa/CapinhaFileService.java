package com.casefy.service.Capa;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jboss.logging.Logger;

import com.casefy.model.Capinha;
import com.casefy.repository.CapinhaRepository;
import com.casefy.resource.ClienteResource;
import com.casefy.validation.ValidationException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CapinhaFileService implements FileService {
    private static final Logger LOG = Logger.getLogger(ClienteResource.class);
    /*  /Users/janio/quarkus/images/usuario/*/
    private final String PATH_USER = System.getProperty("user.home") +
        File.separator + "quarkus" +
        File.separator + "images" +
        File.separator + "usuario" +  File.separator; 

    @Inject
    CapinhaRepository capinhaRepository;
    
     @Override
    @Transactional
    public void salvar(Long id, String nomeImagem, byte[] imagem) {
        Capinha capinha = capinhaRepository.findById(id);

        try {
            LOG.info("Salvando imagem");
            String novoNomeImagem = salvarImagem(imagem, nomeImagem);
            capinha.setNomeImagem(novoNomeImagem);
            // excluir a imagem antiga (trabalho pra quem????)
        } catch (IOException e) {
            LOG.info("Não salvou a imagem");
            throw new ValidationException("imagem", e.toString());
        }
    }

    private String salvarImagem(byte[] imagem, String nomeImagem) throws IOException {
        
        // verificando o tipo da imagem
        LOG.info("Salvando imagem");
        String mimeType = Files.probeContentType(new File(nomeImagem).toPath());
        List<String> listMimeType = Arrays.asList("image/jpg", "image/jpeg", "image/png", "image/gif");
        if (!listMimeType.contains(mimeType)) {
            throw new IOException("Tipo de imagem não suportada.");
        }

        // verificando o tamanho do arquivo - nao permitir maior que 10 megas
        if (imagem.length > (1024 * 1024 * 10))
            throw new IOException("Arquivo muito grande.");

        // criando as pastas quando não existir
        File diretorio = new File(PATH_USER);
        if (!diretorio.exists())
            diretorio.mkdirs();

        // gerando o nome do arquivo
        String nomeArquivo = UUID.randomUUID()
        +"."+mimeType.substring(mimeType.lastIndexOf("/")+1);

        String path = PATH_USER + nomeArquivo;

        // salvando o arquivo
        File file = new File(path);
        // alunos (melhorar :)
        if (file.exists())
            throw new IOException("O nome gerado da imagem está repedido.");

        // criando um arquivo no S.O.
        file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagem);
        // garantindo o envio do ultimo lote de bytes
        fos.flush();
        fos.close();
        LOG.info("Salvo a imagem");
        return nomeArquivo;
    
    }

    @Override
    public File download(String nomeArquivo) {
        LOG.info("Download imagem concluida");
        File file = new File(PATH_USER+nomeArquivo);
        return file;
    } 
}
