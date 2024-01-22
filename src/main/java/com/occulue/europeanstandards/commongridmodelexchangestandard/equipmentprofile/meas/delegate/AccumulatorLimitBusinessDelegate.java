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
 * AccumulatorLimit business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of AccumulatorLimit related services in the case of a
 *       AccumulatorLimit business related service failing.
 *   <li>Exposes a simpler, uniform AccumulatorLimit interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill AccumulatorLimit business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class AccumulatorLimitBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public AccumulatorLimitBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * AccumulatorLimit Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return AccumulatorLimitBusinessDelegate
   */
  public static AccumulatorLimitBusinessDelegate getAccumulatorLimitInstance() {
    return (new AccumulatorLimitBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createAccumulatorLimit(CreateAccumulatorLimitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getAccumulatorLimitId() == null) command.setAccumulatorLimitId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      AccumulatorLimitValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateAccumulatorLimitCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateAccumulatorLimitCommand of AccumulatorLimit is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create AccumulatorLimit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateAccumulatorLimitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateAccumulatorLimit(UpdateAccumulatorLimitCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      AccumulatorLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateAccumulatorLimitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save AccumulatorLimit - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteAccumulatorLimitCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteAccumulatorLimitCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AccumulatorLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteAccumulatorLimitCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete AccumulatorLimit using Id = " + command.getAccumulatorLimitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the AccumulatorLimit via AccumulatorLimitFetchOneSummary
   *
   * @param summary AccumulatorLimitFetchOneSummary
   * @return AccumulatorLimitFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public AccumulatorLimit getAccumulatorLimit(AccumulatorLimitFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("AccumulatorLimitFetchOneSummary arg cannot be null");

    AccumulatorLimit entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      AccumulatorLimitValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a AccumulatorLimit
      // --------------------------------------
      CompletableFuture<AccumulatorLimit> futureEntity =
          queryGateway.query(
              new FindAccumulatorLimitQuery(
                  new LoadAccumulatorLimitFilter(summary.getAccumulatorLimitId())),
              ResponseTypes.instanceOf(AccumulatorLimit.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate AccumulatorLimit with id " + summary.getAccumulatorLimitId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all AccumulatorLimits
   *
   * @return List<AccumulatorLimit>
   * @exception ProcessingException Thrown if any problems
   */
  public List<AccumulatorLimit> getAllAccumulatorLimit() throws ProcessingException {
    List<AccumulatorLimit> list = null;

    try {
      CompletableFuture<List<AccumulatorLimit>> futureList =
          queryGateway.query(
              new FindAllAccumulatorLimitQuery(),
              ResponseTypes.multipleInstancesOf(AccumulatorLimit.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all AccumulatorLimit";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on AccumulatorLimit
   *
   * @param command AssignValueToAccumulatorLimitCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToAccumulatorLimitCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAccumulatorLimitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    AccumulatorLimitBusinessDelegate parentDelegate =
        AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AccumulatorLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get IntegerProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Value on AccumulatorLimit
   *
   * @param command UnAssignValueFromAccumulatorLimitCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromAccumulatorLimitCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AccumulatorLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on AccumulatorLimit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add AccumulatorLimit to Limits
   *
   * @param command AssignLimitsToAccumulatorLimitCommand
   * @exception ProcessingException
   */
  public void addToLimits(AssignLimitsToAccumulatorLimitCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getAccumulatorLimitId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .AccumulatorLimitBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance();
    AccumulatorLimitBusinessDelegate parentDelegate =
        AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance();
    UUID childId = command.getAddTo().getAccumulatorLimitId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AccumulatorLimitValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a AccumulatorLimit as Limits to AccumulatorLimit";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove AccumulatorLimit from Limits
   *
   * @param command RemoveLimitsFromAccumulatorLimitCommand
   * @exception ProcessingException
   */
  public void removeFromLimits(RemoveLimitsFromAccumulatorLimitCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .AccumulatorLimitBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance();
    UUID childId = command.getRemoveFrom().getAccumulatorLimitId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      AccumulatorLimitValidator.getInstance().validate(command);

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
   * @return AccumulatorLimit
   */
  private AccumulatorLimit load(UUID id) throws ProcessingException {
    accumulatorLimit =
        AccumulatorLimitBusinessDelegate.getAccumulatorLimitInstance()
            .getAccumulatorLimit(new AccumulatorLimitFetchOneSummary(id));
    return accumulatorLimit;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private AccumulatorLimit accumulatorLimit = null;
  private static final Logger LOGGER =
      Logger.getLogger(AccumulatorLimitBusinessDelegate.class.getName());
}
