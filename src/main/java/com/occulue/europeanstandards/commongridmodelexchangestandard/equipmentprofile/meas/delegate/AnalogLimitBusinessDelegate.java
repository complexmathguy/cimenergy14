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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.validator.*;
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
 * AnalogLimit business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of AnalogLimit related services in the case of a AnalogLimit
 *       business related service failing.
 *   <li>Exposes a simpler, uniform AnalogLimit interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill AnalogLimit business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class AnalogLimitBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public AnalogLimitBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * AnalogLimit Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return AnalogLimitBusinessDelegate
   */
  public static AnalogLimitBusinessDelegate getAnalogLimitInstance() {
    return (new AnalogLimitBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createAnalogLimit(CreateAnalogLimitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getAnalogLimitId() == null) command.setAnalogLimitId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogLimitValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateAnalogLimitCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateAnalogLimitCommand of AnalogLimit is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create AnalogLimit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateAnalogLimitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateAnalogLimit(UpdateAnalogLimitCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      AnalogLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateAnalogLimitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save AnalogLimit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteAnalogLimitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteAnalogLimitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteAnalogLimitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete AnalogLimit using Id = " + command.getAnalogLimitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the AnalogLimit via AnalogLimitFetchOneSummary
   *
   * @param summary AnalogLimitFetchOneSummary
   * @return AnalogLimitFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public AnalogLimit getAnalogLimit(AnalogLimitFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("AnalogLimitFetchOneSummary arg cannot be null");

    AnalogLimit entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      AnalogLimitValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a AnalogLimit
      // --------------------------------------
      CompletableFuture<AnalogLimit> futureEntity =
          queryGateway.query(
              new FindAnalogLimitQuery(new LoadAnalogLimitFilter(summary.getAnalogLimitId())),
              ResponseTypes.instanceOf(AnalogLimit.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate AnalogLimit with id " + summary.getAnalogLimitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all AnalogLimits
   *
   * @return List<AnalogLimit>
   * @exception ProcessingException Thrown if any problems
   */
  public List<AnalogLimit> getAllAnalogLimit() throws ProcessingException {
    List<AnalogLimit> list = null;

    try {
      CompletableFuture<List<AnalogLimit>> futureList =
          queryGateway.query(
              new FindAllAnalogLimitQuery(), ResponseTypes.multipleInstancesOf(AnalogLimit.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all AnalogLimit";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on AnalogLimit
   *
   * @param command AssignValueToAnalogLimitCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToAnalogLimitCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAnalogLimitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    AnalogLimitBusinessDelegate parentDelegate =
        AnalogLimitBusinessDelegate.getAnalogLimitInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AnalogLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Value on AnalogLimit
   *
   * @param command UnAssignValueFromAnalogLimitCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromAnalogLimitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on AnalogLimit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add AnalogLimit to Limits
   *
   * @param command AssignLimitsToAnalogLimitCommand
   * @exception ProcessingException
   */
  public void addToLimits(AssignLimitsToAnalogLimitCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getAnalogLimitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .AnalogLimitBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.AnalogLimitBusinessDelegate.getAnalogLimitInstance();
    AnalogLimitBusinessDelegate parentDelegate =
        AnalogLimitBusinessDelegate.getAnalogLimitInstance();
    UUID childId = command.getAddTo().getAnalogLimitId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a AnalogLimit as Limits to AnalogLimit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove AnalogLimit from Limits
   *
   * @param command RemoveLimitsFromAnalogLimitCommand
   * @exception ProcessingException
   */
  public void removeFromLimits(RemoveLimitsFromAnalogLimitCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .AnalogLimitBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.AnalogLimitBusinessDelegate.getAnalogLimitInstance();
    UUID childId = command.getRemoveFrom().getAnalogLimitId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogLimitValidator.getInstance().validate(command);

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
   * @return AnalogLimit
   */
  private AnalogLimit load(UUID id) throws ProcessingException {
    analogLimit =
        AnalogLimitBusinessDelegate.getAnalogLimitInstance()
            .getAnalogLimit(new AnalogLimitFetchOneSummary(id));
    return analogLimit;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private AnalogLimit analogLimit = null;
  private static final Logger LOGGER =
      Logger.getLogger(AnalogLimitBusinessDelegate.class.getName());
}
