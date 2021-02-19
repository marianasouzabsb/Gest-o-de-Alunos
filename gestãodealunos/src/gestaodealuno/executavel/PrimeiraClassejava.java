package gestaodealuno.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import gestaodealunos.classes.Aluno;
import gestaodealunos.classes.Disciplina;
import gestãodealunos.contantes.StatusAluno;

public class PrimeiraClassejava {

	public static void main(String[] args) {
		
		//Validação de usuario de senha
		String login = JOptionPane.showInputDialog("Informe o LOgin");
		String senha = JOptionPane.showInputDialog("Informe o senha");
		
		if (login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")){

		List<Aluno> alunos = new ArrayList<Aluno>(); // Criando lista de alunos

		// Hashmap é uma lista com chave que identifica uma squencia de valores
		HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

		for (int qtd = 1; qtd <= 5; qtd++) {
			// Recebe os dados via teclado
			String nome = JOptionPane.showInputDialog("Qual o nome do Aluno " + qtd + "?");
			String idade = JOptionPane.showInputDialog("Digite a Idade do Aluno");
			String dataNascimento = JOptionPane.showInputDialog("Digite data de nascimento");

			Aluno aluno1 = new Aluno();// faz referencia ao construtor

			aluno1.setNome(nome);
			aluno1.setIdade(Integer.valueOf(idade));
			aluno1.setDataNascimento(dataNascimento);

			// Para adicionar Disciplinas
			for (int pos = 1; pos <= 1; pos++) {
				String nomeDisciplina = JOptionPane.showInputDialog("Digite disciplina " + pos + " ? ");
				String notaDisciplina = JOptionPane.showInputDialog("Digite nota " + pos + " ? ");

				Disciplina disciplina = new Disciplina();

				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(Double.valueOf(notaDisciplina));

				aluno1.getDisciplinas().add(disciplina);
			}
			// Para Remover disciplinas

			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina");
			if (escolha == 0) { // opção sim é 0
				int continuarRemover = 0;
				int posicao = 1;
				while (continuarRemover == 0) {
					String disciplinaRemover = JOptionPane
							.showInputDialog("Qual disciplina deseja remover? 1,2,3 ou 4	");
					aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
					posicao++;
					continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a Remover disciplinas? ");
				} // fecha while
			}
			alunos.add(aluno1); // ADD ALUNO NA LISTA
		} // fecha For da lista de alunos

		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

		for (Aluno aluno : alunos) {
			if (aluno.getAlunoResultado().equalsIgnoreCase(StatusAluno.APROVADO)) {
				maps.get(StatusAluno.APROVADO).add(aluno);

			} else if (aluno.getAlunoResultado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				maps.get(StatusAluno.RECUPERACAO).add(aluno);
			} else {
				maps.get(StatusAluno.REPROVADO).add(aluno);
			}

		}

		System.out.println("============Lista dos Aprovados==============");
		for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
			System.out.println(aluno.getNome());
		}

		System.out.println("==============Lista dos Recuperação==============");
		for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
			System.out.println(aluno.getNome());
		}

		System.out.println("===========Lista dos Reprovados===============");
		for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
			System.out.println(aluno.getNome());
		}
		
		}//fecha validação
		else {
			System.out.println("Informe o senha e login");
		}

		/*
		 * for (int pos = 0; pos < alunos.size(); pos++) {
		 * 
		 * Aluno aluno = alunos.get(pos);
		 * 
		 * System.out.println("aluno: " + aluno.getNome()); System.out.println("Média: "
		 * + aluno.getMediaNota());
		 * 
		 * for (int posd = 0; posd < aluno.getDisciplinas().size(); posd++) {
		 * 
		 * Disciplina disc = aluno.getDisciplinas().get(posd);
		 * 
		 * System.out.println("Materia: " + disc.getDisciplina() + "Nota: " +
		 * disc.getNota());
		 * 
		 * } }
		 */

		/*
		 * for (Aluno aluno : alunos) {
		 * 
		 * if (aluno.getNome().equalsIgnoreCase("mari")) { alunos.remove(aluno); break;
		 * } else { System.out.println(aluno); System.out.println("Média: " +
		 * aluno.getMediaNota()); System.out.println("REsultado: " +
		 * aluno.getAlunoResultado());
		 * System.out.println("=================================================="); } }
		 * for (Aluno aluno : alunos) {
		 * System.out.println("Alunos que sobrarma na lista");
		 * System.out.println(aluno.getNome());
		 * System.out.println("Suas materias são: "); for (Disciplina disciplina :
		 * aluno.getDisciplinas()) { System.out.println(disciplina.getDisciplina()); }
		 * 
		 * }/
		 */

	}// Fecha Main
}// Fecha PrimeiraClassejava
