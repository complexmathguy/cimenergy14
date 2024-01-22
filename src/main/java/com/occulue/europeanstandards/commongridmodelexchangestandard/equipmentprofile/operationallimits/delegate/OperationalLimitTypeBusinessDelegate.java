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
 * OperationalLimitType business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of OperationalLimitType related services in the case of a
 *       OperationalLimitType business related service failing.
 *   <li>Exposes a simpler, uniform OperationalLimitType interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill OperationalLimitType
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class OperationalLimitTypeBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public OperationalLimitTypeBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * OperationalLimitType Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return OperationalLimitTypeBusinessDelegate
   */
  public static OperationalLimitTypeBusinessDelegate getOperationalLimitTypeInstance() {
    return (new OperationalLimitTypeBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createOperationalLimitType(
      CreateOperationalLimitTypeCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getOperationalLimitTypeId() == null)
        command.setOperationalLimitTypeId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      OperationalLimitTypeValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateOperationalLimitTypeCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateOperationalLimitTypeCommand of OperationalLimitType is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create OperationalLimitType - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateOperationalLimitTypeCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateOperationalLimitType(
      UpdateOperationalLimitTypeCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      OperationalLimitTypeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateOperationalLimitTypeCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save OperationalLimitType - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteOperationalLimitTypeCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteOperationalLimitTypeCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OperationalLimitTypeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteOperationalLimitTypeCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete OperationalLimitType using Id = " + command.getOperationalLimitTypeId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the OperationalLimitType via OperationalLimitTypeFetchOneSummary
   *
   * @param summary OperationalLimitTypeFetchOneSummary
   * @return OperationalLimitTypeFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public OperationalLimitType getOperationalLimitType(OperationalLimitTypeFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("OperationalLimitTypeFetchOneSummary arg cannot be null");

    OperationalLimitType entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      OperationalLimitTypeValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a OperationalLimitType
      // --------------------------------------
      CompletableFuture<OperationalLimitType> futureEntity =
          queryGateway.query(
              new FindOperationalLimitTypeQuery(
                  new LoadOperationalLimitTypeFilter(summary.getOperationalLimitTypeId())),
              ResponseTypes.instanceOf(OperationalLimitType.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate OperationalLimitType with id " + summary.getOperationalLimitTypeId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all OperationalLimitTypes
   *
   * @return List<OperationalLimitType>
   * @exception ProcessingException Thrown if any problems
   */
  public List<OperationalLimitType> getAllOperationalLimitType() throws ProcessingException {
    List<OperationalLimitType> list = null;

    try {
      CompletableFuture<List<OperationalLimitType>> futureList =
          queryGateway.query(
              new FindAllOperationalLimitTypeQuery(),
              ResponseTypes.multipleInstancesOf(OperationalLimitType.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all OperationalLimitType";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign AcceptableDuration on OperationalLimitType
   *
   * @param command AssignAcceptableDurationToOperationalLimitTypeCommand
   * @exception ProcessingException
   */
  public void assignAcceptableDuration(
      AssignAcceptableDurationToOperationalLimitTypeCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getOperationalLimitTypeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    OperationalLimitTypeBusinessDelegate parentDelegate =
        OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      OperationalLimitTypeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign AcceptableDuration on OperationalLimitType
   *
   * @param command UnAssignAcceptableDurationFromOperationalLimitTypeCommand
   * @exception ProcessingException
   */
  public void unAssignAcceptableDuration(
      UnAssignAcceptableDurationFromOperationalLimitTypeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      OperationalLimitTypeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign AcceptableDuration on OperationalLimitType";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return OperationalLimitType
   */
  private OperationalLimitType load(UUID id) throws ProcessingException {
    operationalLimitType =
        OperationalLimitTypeBusinessDelegate.getOperationalLimitTypeInstance()
            .getOperationalLimitType(new OperationalLimitTypeFetchOneSummary(id));
    return operationalLimitType;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private OperationalLimitType operationalLimitType = null;
  private static final Logger LOGGER =
      Logger.getLogger(OperationalLimitTypeBusinessDelegate.class.getName());
}
