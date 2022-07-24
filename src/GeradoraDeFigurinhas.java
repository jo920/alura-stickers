import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream,String nomearquivo) throws Exception {

        
        /* leitura da imagem por meio de uma URL

        InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_3.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
        /* 
            2°Opção: Estou lendo uma imagem que esta dentro de um arquivo
        InputStream inputStream = new FileInputStream(new File("entrada/TopMovies.jpg"));
        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/TopMovies.jpg"));

        */
        
        // cria nova imagem em memoria com transparencia e com tamanho novo

        
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
        int largura = imagemOriginal.getWidth();

        int altura = imagemOriginal.getHeight();

        int novaAltura = altura +200;

        BufferedImage novaImagem = new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);


        // copiar a imagem original pra novo imagem (em memoria)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,0,0,null);


         // Configurando a fonte
         var font = new Font(Font.SANS_SERIF,Font.BOLD,100);
         graphics.setColor(Color.RED);
         graphics.setFont(font);



        // escrever uma frase nova na imagem
        graphics.drawString("TOP DEMAIS", 0, novaAltura -100);
        


        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomearquivo));
    }

}
