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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.validator.*;
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
 * ConformLoad business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ConformLoad related services in the case of a ConformLoad
 *       business related service failing.
 *   <li>Exposes a simpler, uniform ConformLoad interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ConformLoad business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ConformLoadBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ConformLoadBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ConformLoad Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ConformLoadBusinessDelegate
   */
  public static ConformLoadBusinessDelegate getConformLoadInstance() {
    return (new ConformLoadBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createConformLoad(CreateConformLoadCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getConformLoadId() == null) command.setConformLoadId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConformLoadValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateConformLoadCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateConformLoadCommand of ConformLoad is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ConformLoad - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateConformLoadCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateConformLoad(UpdateConformLoadCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ConformLoadValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateConformLoadCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ConformLoad - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteConformLoadCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteConformLoadCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConformLoadValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteConformLoadCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete ConformLoad using Id = " + command.getConformLoadId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ConformLoad via ConformLoadFetchOneSummary
   *
   * @param summary ConformLoadFetchOneSummary
   * @return ConformLoadFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ConformLoad getConformLoad(ConformLoadFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ConformLoadFetchOneSummary arg cannot be null");

    ConformLoad entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ConformLoadValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ConformLoad
      // --------------------------------------
      CompletableFuture<ConformLoad> futureEntity =
          queryGateway.query(
              new FindConformLoadQuery(new LoadConformLoadFilter(summary.getConformLoadId())),
              ResponseTypes.instanceOf(ConformLoad.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate ConformLoad with id " + summary.getConformLoadId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ConformLoads
   *
   * @return List<ConformLoad>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ConformLoad> getAllConformLoad() throws ProcessingException {
    List<ConformLoad> list = null;

    try {
      CompletableFuture<List<ConformLoad>> futureList =
          queryGateway.query(
              new FindAllConformLoadQuery(), ResponseTypes.multipleInstancesOf(ConformLoad.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ConformLoad";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add ConformLoad to EnergyConsumers
   *
   * @param command AssignEnergyConsumersToConformLoadCommand
   * @exception ProcessingException
   */
  public void addToEnergyConsumers(AssignEnergyConsumersToConformLoadCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getConformLoadId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel
            .delegate.ConformLoadBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel
                .delegate.ConformLoadBusinessDelegate.getConformLoadInstance();
    ConformLoadBusinessDelegate parentDelegate =
        ConformLoadBusinessDelegate.getConformLoadInstance();
    UUID childId = command.getAddTo().getConformLoadId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConformLoadValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a ConformLoad as EnergyConsumers to ConformLoad";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove ConformLoad from EnergyConsumers
   *
   * @param command RemoveEnergyConsumersFromConformLoadCommand
   * @exception ProcessingException
   */
  public void removeFromEnergyConsumers(RemoveEnergyConsumersFromConformLoadCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel
            .delegate.ConformLoadBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel
                .delegate.ConformLoadBusinessDelegate.getConformLoadInstance();
    UUID childId = command.getRemoveFrom().getConformLoadId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConformLoadValidator.getInstance().validate(command);

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
   * @return ConformLoad
   */
  private ConformLoad load(UUID id) throws ProcessingException {
    conformLoad =
        ConformLoadBusinessDelegate.getConformLoadInstance()
            .getConformLoad(new ConformLoadFetchOneSummary(id));
    return conformLoad;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ConformLoad conformLoad = null;
  private static final Logger LOGGER =
      Logger.getLogger(ConformLoadBusinessDelegate.class.getName());
}
