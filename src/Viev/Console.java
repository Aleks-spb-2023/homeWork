package Viev;

import presenter.Presenter;
import java.util.Scanner;
import Model.FamilyFree;
import Model.Human;

public class Console implements View
{
    private Scanner scan;
    private Presenter presenter;
    private Menu menu;
    private boolean go;

    @Override
    public void start()
    {
        scan = new Scanner(System.in);
        menu = new Menu(this);
        go = true;
        while (go)
        {
            header();
            menuUi();
            System.out.print("�������� ����� ���� -> ");
            String command = scan.nextLine();
            if (checkInput(command))
            {
                menu.execute(Integer.parseInt(command));
            }
            else
            {
                System.out.println("������� �����!");
            }
        }
    }


    private void header()
    {
        System.out.println("\n" +
                " � ������ ��������� �������� �����, \n ���������� � ����� ��������� �����");
    }

    private void menuUi()
    {
        System.out.println(menu.printMenu());
    }

    public void addHumanNew()
    {
        presenter.AddHumanNew();
    }

    public void end()
    {
        go = false;
        System.out.println("������� ��� ����������� ����� �������� :D");
    }

    public void familyPrint()
    {
        presenter.familyPrint();
    }

    public void humanSearch()
    {
        presenter.humanSearch();
    }

    @Override
    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public String scan()
    {
        scan = new Scanner(System.in, "Cp866");
        return scan.nextLine();
    }

    private boolean checkInput(String text)
    {
        return text.matches("[0-9]+");
    }

    @Override
    public void print(String text)
    {
        System.out.println(text);
    }

    @Override
    public void print(Human chelovek)
    {
        System.out.println(chelovek);
    }

    @Override
    public void print(FamilyFree<Human> FamilyFree)
    {
        System.out.println(FamilyFree);
    }
}