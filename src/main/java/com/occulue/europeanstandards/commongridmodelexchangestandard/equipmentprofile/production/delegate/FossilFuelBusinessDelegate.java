/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * FossilFuel business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of FossilFuel related services in the case of a FossilFuel business
 *       related service failing.
 *   <li>Exposes a simpler, uniform FossilFuel interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill FossilFuel business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class FossilFuelBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public FossilFuelBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * FossilFuel Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return FossilFuelBusinessDelegate
   */
  public static FossilFuelBusinessDelegate getFossilFuelInstance() {
    return (new FossilFuelBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createFossilFuel(CreateFossilFuelCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getFossilFuelId() == null) command.setFossilFuelId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      FossilFuelValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateFossilFuelCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateFossilFuelCommand of FossilFuel is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create FossilFuel - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateFossilFuelCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateFossilFuel(UpdateFossilFuelCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      FossilFuelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateFossilFuelCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save FossilFuel - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteFossilFuelCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteFossilFuelCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      FossilFuelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteFossilFuelCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete FossilFuel using Id = " + command.getFossilFuelId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the FossilFuel via FossilFuelFetchOneSummary
   *
   * @param summary FossilFuelFetchOneSummary
   * @return FossilFuelFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public FossilFuel getFossilFuel(FossilFuelFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("FossilFuelFetchOneSummary arg cannot be null");

    FossilFuel entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      FossilFuelValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a FossilFuel
      // --------------------------------------
      CompletableFuture<FossilFuel> futureEntity =
          queryGateway.query(
              new FindFossilFuelQuery(new LoadFossilFuelFilter(summary.getFossilFuelId())),
              ResponseTypes.instanceOf(FossilFuel.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate FossilFuel with id " + summary.getFossilFuelId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all FossilFuels
   *
   * @return List<FossilFuel>
   * @exception ProcessingException Thrown if any problems
   */
  public List<FossilFuel> getAllFossilFuel() throws ProcessingException {
    List<FossilFuel> list = null;

    try {
      CompletableFuture<List<FossilFuel>> futureList =
          queryGateway.query(
              new FindAllFossilFuelQuery(), ResponseTypes.multipleInstancesOf(FossilFuel.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all FossilFuel";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add FossilFuel to FossilFuels
   *
   * @param command AssignFossilFuelsToFossilFuelCommand
   * @exception ProcessingException
   */
  public void addToFossilFuels(AssignFossilFuelsToFossilFuelCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getFossilFuelId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
            .delegate.FossilFuelBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .production.delegate.FossilFuelBusinessDelegate.getFossilFuelInstance();
    FossilFuelBusinessDelegate parentDelegate = FossilFuelBusinessDelegate.getFossilFuelInstance();
    UUID childId = command.getAddTo().getFossilFuelId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      FossilFuelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a FossilFuel as FossilFuels to FossilFuel";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove FossilFuel from FossilFuels
   *
   * @param command RemoveFossilFuelsFromFossilFuelCommand
   * @exception ProcessingException
   */
  public void removeFromFossilFuels(RemoveFossilFuelsFromFossilFuelCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
            .delegate.FossilFuelBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .production.delegate.FossilFuelBusinessDelegate.getFossilFuelInstance();
    UUID childId = command.getRemoveFrom().getFossilFuelId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      FossilFuelValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return FossilFuel
   */
  private FossilFuel load(UUID id) throws ProcessingException {
    fossilFuel =
        FossilFuelBusinessDelegate.getFossilFuelInstance()
            .getFossilFuel(new FossilFuelFetchOneSummary(id));
    return fossilFuel;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private FossilFuel fossilFuel = null;
  private static final Logger LOGGER = Logger.getLogger(FossilFuelBusinessDelegate.class.getName());
}
