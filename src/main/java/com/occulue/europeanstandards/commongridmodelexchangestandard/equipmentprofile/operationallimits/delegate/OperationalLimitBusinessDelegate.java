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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.validator.*;
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
 * OperationalLimit business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of OperationalLimit related services in the case of a
 *       OperationalLimit business related service failing.
 *   <li>Exposes a simpler, uniform OperationalLimit interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill OperationalLimit business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class OperationalLimitBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public OperationalLimitBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * OperationalLimit Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return OperationalLimitBusinessDelegate
   */
  public static OperationalLimitBusinessDelegate getOperationalLimitInstance() {
    return (new OperationalLimitBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createOperationalLimit(CreateOperationalLimitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getOperationalLimitId() == null) command.setOperationalLimitId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      OperationalLimitValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateOperationalLimitCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateOperationalLimitCommand of OperationalLimit is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create OperationalLimit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateOperationalLimitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateOperationalLimit(UpdateOperationalLimitCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      OperationalLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateOperationalLimitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save OperationalLimit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteOperationalLimitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteOperationalLimitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OperationalLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteOperationalLimitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete OperationalLimit using Id = " + command.getOperationalLimitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the OperationalLimit via OperationalLimitFetchOneSummary
   *
   * @param summary OperationalLimitFetchOneSummary
   * @return OperationalLimitFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public OperationalLimit getOperationalLimit(OperationalLimitFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("OperationalLimitFetchOneSummary arg cannot be null");

    OperationalLimit entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      OperationalLimitValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a OperationalLimit
      // --------------------------------------
      CompletableFuture<OperationalLimit> futureEntity =
          queryGateway.query(
              new FindOperationalLimitQuery(
                  new LoadOperationalLimitFilter(summary.getOperationalLimitId())),
              ResponseTypes.instanceOf(OperationalLimit.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate OperationalLimit with id " + summary.getOperationalLimitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all OperationalLimits
   *
   * @return List<OperationalLimit>
   * @exception ProcessingException Thrown if any problems
   */
  public List<OperationalLimit> getAllOperationalLimit() throws ProcessingException {
    List<OperationalLimit> list = null;

    try {
      CompletableFuture<List<OperationalLimit>> futureList =
          queryGateway.query(
              new FindAllOperationalLimitQuery(),
              ResponseTypes.multipleInstancesOf(OperationalLimit.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all OperationalLimit";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add OperationalLimit to OperationalLimit
   *
   * @param command AssignOperationalLimitToOperationalLimitCommand
   * @exception ProcessingException
   */
  public void addToOperationalLimit(AssignOperationalLimitToOperationalLimitCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getOperationalLimitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits
            .delegate.OperationalLimitBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .operationallimits.delegate.OperationalLimitBusinessDelegate
                .getOperationalLimitInstance();
    OperationalLimitBusinessDelegate parentDelegate =
        OperationalLimitBusinessDelegate.getOperationalLimitInstance();
    UUID childId = command.getAddTo().getOperationalLimitId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OperationalLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a OperationalLimit as OperationalLimit to OperationalLimit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove OperationalLimit from OperationalLimit
   *
   * @param command RemoveOperationalLimitFromOperationalLimitCommand
   * @exception ProcessingException
   */
  public void removeFromOperationalLimit(RemoveOperationalLimitFromOperationalLimitCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits
            .delegate.OperationalLimitBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .operationallimits.delegate.OperationalLimitBusinessDelegate
                .getOperationalLimitInstance();
    UUID childId = command.getRemoveFrom().getOperationalLimitId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      OperationalLimitValidator.getInstance().validate(command);

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
   * add OperationalLimit to OperationalLimitValue
   *
   * @param command AssignOperationalLimitValueToOperationalLimitCommand
   * @exception ProcessingException
   */
  public void addToOperationalLimitValue(
      AssignOperationalLimitValueToOperationalLimitCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getOperationalLimitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits
            .delegate.OperationalLimitBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .operationallimits.delegate.OperationalLimitBusinessDelegate
                .getOperationalLimitInstance();
    OperationalLimitBusinessDelegate parentDelegate =
        OperationalLimitBusinessDelegate.getOperationalLimitInstance();
    UUID childId = command.getAddTo().getOperationalLimitId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OperationalLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a OperationalLimit as OperationalLimitValue to OperationalLimit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove OperationalLimit from OperationalLimitValue
   *
   * @param command RemoveOperationalLimitValueFromOperationalLimitCommand
   * @exception ProcessingException
   */
  public void removeFromOperationalLimitValue(
      RemoveOperationalLimitValueFromOperationalLimitCommand command) throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits
            .delegate.OperationalLimitBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .operationallimits.delegate.OperationalLimitBusinessDelegate
                .getOperationalLimitInstance();
    UUID childId = command.getRemoveFrom().getOperationalLimitId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      OperationalLimitValidator.getInstance().validate(command);

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
   * @return OperationalLimit
   */
  private OperationalLimit load(UUID id) throws ProcessingException {
    operationalLimit =
        OperationalLimitBusinessDelegate.getOperationalLimitInstance()
            .getOperationalLimit(new OperationalLimitFetchOneSummary(id));
    return operationalLimit;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private OperationalLimit operationalLimit = null;
  private static final Logger LOGGER =
      Logger.getLogger(OperationalLimitBusinessDelegate.class.getName());
}
