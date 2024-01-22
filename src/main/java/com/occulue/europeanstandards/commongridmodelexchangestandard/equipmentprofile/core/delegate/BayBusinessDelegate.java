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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.validator.*;
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
 * Bay business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Bay related services in the case of a Bay business related
 *       service failing.
 *   <li>Exposes a simpler, uniform Bay interface to the business tier, making it easy for clients
 *       to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Bay business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class BayBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public BayBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Bay Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return BayBusinessDelegate
   */
  public static BayBusinessDelegate getBayInstance() {
    return (new BayBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createBay(CreateBayCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getBayId() == null) command.setBayId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      BayValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateBayCommand - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO, "return from Command Gateway for CreateBayCommand of Bay is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Bay - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateBayCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateBay(UpdateBayCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      BayValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateBayCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Bay - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteBayCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteBayCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BayValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteBayCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Bay using Id = " + command.getBayId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Bay via BayFetchOneSummary
   *
   * @param summary BayFetchOneSummary
   * @return BayFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Bay getBay(BayFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("BayFetchOneSummary arg cannot be null");

    Bay entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      BayValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Bay
      // --------------------------------------
      CompletableFuture<Bay> futureEntity =
          queryGateway.query(
              new FindBayQuery(new LoadBayFilter(summary.getBayId())),
              ResponseTypes.instanceOf(Bay.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Bay with id " + summary.getBayId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Bays
   *
   * @return List<Bay>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Bay> getAllBay() throws ProcessingException {
    List<Bay> list = null;

    try {
      CompletableFuture<List<Bay>> futureList =
          queryGateway.query(new FindAllBayQuery(), ResponseTypes.multipleInstancesOf(Bay.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Bay";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add Bay to Bays
   *
   * @param command AssignBaysToBayCommand
   * @exception ProcessingException
   */
  public void addToBays(AssignBaysToBayCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getBayId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate
            .BayBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core
                .delegate.BayBusinessDelegate.getBayInstance();
    BayBusinessDelegate parentDelegate = BayBusinessDelegate.getBayInstance();
    UUID childId = command.getAddTo().getBayId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      BayValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a Bay as Bays to Bay";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove Bay from Bays
   *
   * @param command RemoveBaysFromBayCommand
   * @exception ProcessingException
   */
  public void removeFromBays(RemoveBaysFromBayCommand command) throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate
            .BayBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core
                .delegate.BayBusinessDelegate.getBayInstance();
    UUID childId = command.getRemoveFrom().getBayId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      BayValidator.getInstance().validate(command);

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
   * @return Bay
   */
  private Bay load(UUID id) throws ProcessingException {
    bay = BayBusinessDelegate.getBayInstance().getBay(new BayFetchOneSummary(id));
    return bay;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Bay bay = null;
  private static final Logger LOGGER = Logger.getLogger(BayBusinessDelegate.class.getName());
}
