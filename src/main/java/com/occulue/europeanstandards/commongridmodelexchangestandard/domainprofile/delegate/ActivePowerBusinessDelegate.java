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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator.*;
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
 * ActivePower business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ActivePower related services in the case of a ActivePower
 *       business related service failing.
 *   <li>Exposes a simpler, uniform ActivePower interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ActivePower business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ActivePowerBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ActivePowerBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ActivePower Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ActivePowerBusinessDelegate
   */
  public static ActivePowerBusinessDelegate getActivePowerInstance() {
    return (new ActivePowerBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createActivePower(CreateActivePowerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getActivePowerId() == null) command.setActivePowerId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ActivePowerValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateActivePowerCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateActivePowerCommand of ActivePower is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ActivePower - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateActivePowerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateActivePower(UpdateActivePowerCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ActivePowerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateActivePowerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ActivePower - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteActivePowerCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteActivePowerCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ActivePowerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteActivePowerCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete ActivePower using Id = " + command.getActivePowerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ActivePower via ActivePowerFetchOneSummary
   *
   * @param summary ActivePowerFetchOneSummary
   * @return ActivePowerFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ActivePower getActivePower(ActivePowerFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ActivePowerFetchOneSummary arg cannot be null");

    ActivePower entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ActivePowerValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ActivePower
      // --------------------------------------
      CompletableFuture<ActivePower> futureEntity =
          queryGateway.query(
              new FindActivePowerQuery(new LoadActivePowerFilter(summary.getActivePowerId())),
              ResponseTypes.instanceOf(ActivePower.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate ActivePower with id " + summary.getActivePowerId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ActivePowers
   *
   * @return List<ActivePower>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ActivePower> getAllActivePower() throws ProcessingException {
    List<ActivePower> list = null;

    try {
      CompletableFuture<List<ActivePower>> futureList =
          queryGateway.query(
              new FindAllActivePowerQuery(), ResponseTypes.multipleInstancesOf(ActivePower.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ActivePower";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on ActivePower
   *
   * @param command AssignValueToActivePowerCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToActivePowerCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getActivePowerId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FloatProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FloatProxyBusinessDelegate.getFloatProxyInstance();
    ActivePowerBusinessDelegate parentDelegate =
        ActivePowerBusinessDelegate.getActivePowerInstance();
    UUID childId = command.getAssignment().getFloatProxyId();
    FloatProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ActivePowerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get FloatProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Value on ActivePower
   *
   * @param command UnAssignValueFromActivePowerCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromActivePowerCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ActivePowerValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on ActivePower";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ActivePower
   */
  private ActivePower load(UUID id) throws ProcessingException {
    activePower =
        ActivePowerBusinessDelegate.getActivePowerInstance()
            .getActivePower(new ActivePowerFetchOneSummary(id));
    return activePower;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ActivePower activePower = null;
  private static final Logger LOGGER =
      Logger.getLogger(ActivePowerBusinessDelegate.class.getName());
}
