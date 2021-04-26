package by.jwd.restaurant.service.impl;

import by.jwd.restaurant.dao.DAOProvider;
import by.jwd.restaurant.dao.DrinkDAO;
import by.jwd.restaurant.dao.exception.DAOException;
import by.jwd.restaurant.entity.Drink;
import by.jwd.restaurant.service.DrinkService;
import by.jwd.restaurant.service.exception.ServiceException;

import java.util.List;

public class DrinkServiceImpl implements DrinkService {
    @Override
    public List<Drink> getDrinks() throws ServiceException {
        List<Drink> allDrinks = null;

        DAOProvider provider = DAOProvider.getInstance();
        DrinkDAO drinkDAO = provider.getDrinkDAO();

        try {
            allDrinks = drinkDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException("get drinks exception", e);
        }

        return allDrinks;
    }

    @Override
    public boolean addNewDrink(Drink drink) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        DrinkDAO drinkDAO = provider.getDrinkDAO();

        try {
            drinkDAO.setNewDrink(drink);
        } catch (DAOException e) {
            throw new ServiceException("add new drink exception", e);
        }

        return true;
    }

    @Override
    public void makeNotAvailable(Integer id) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        DrinkDAO drinkDAO = provider.getDrinkDAO();

        try {
            drinkDAO.updateDrinkNotAvailable(id);
        } catch (DAOException e) {
            throw new ServiceException("update drink not available exception", e);
        }
    }

    @Override
    public Drink getDrink(Integer id) throws ServiceException {
        Drink drink;

        DAOProvider provider = DAOProvider.getInstance();
        DrinkDAO drinkDAO = provider.getDrinkDAO();

        try {
            drink = drinkDAO.getDrink(id);
        } catch (DAOException e) {
            throw new ServiceException("get drink exception", e);
        }

        return drink;
    }

    @Override
    public void updateDrink(Drink drink) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        DrinkDAO drinkDAO = provider.getDrinkDAO();

        try {
            drinkDAO.updateDrink(drink);
        } catch (DAOException e) {
            throw new ServiceException("update drink not available exception", e);
        }
    }

    @Override
    public List<Drink> getOrderedDrinks(Integer orderId) throws ServiceException {
        List<Drink> orderedDrinks = null;

        DAOProvider provider = DAOProvider.getInstance();
        DrinkDAO drinkDAO = provider.getDrinkDAO();

        try {
            orderedDrinks = drinkDAO.getOrderedDrinks(orderId);
        } catch (DAOException e) {
            throw new ServiceException("get drinks exception", e);
        }

        return orderedDrinks;
    }

}
