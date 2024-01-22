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
 * AccumulatorValue business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of AccumulatorValue related services in the case of a
 *       AccumulatorValue business related service failing.
 *   <li>Exposes a simpler, uniform AccumulatorValue interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill AccumulatorValue business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class AccumulatorValueBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public AccumulatorValueBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * AccumulatorValue Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return AccumulatorValueBusinessDelegate
   */
  public static AccumulatorValueBusinessDelegate getAccumulatorValueInstance() {
    return (new AccumulatorValueBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createAccumulatorValue(CreateAccumulatorValueCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getAccumulatorValueId() == null) command.setAccumulatorValueId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      AccumulatorValueValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateAccumulatorValueCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateAccumulatorValueCommand of AccumulatorValue is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create AccumulatorValue - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateAccumulatorValueCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateAccumulatorValue(UpdateAccumulatorValueCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      AccumulatorValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateAccumulatorValueCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save AccumulatorValue - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteAccumulatorValueCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteAccumulatorValueCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AccumulatorValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteAccumulatorValueCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete AccumulatorValue using Id = " + command.getAccumulatorValueId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the AccumulatorValue via AccumulatorValueFetchOneSummary
   *
   * @param summary AccumulatorValueFetchOneSummary
   * @return AccumulatorValueFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public AccumulatorValue getAccumulatorValue(AccumulatorValueFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("AccumulatorValueFetchOneSummary arg cannot be null");

    AccumulatorValue entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      AccumulatorValueValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a AccumulatorValue
      // --------------------------------------
      CompletableFuture<AccumulatorValue> futureEntity =
          queryGateway.query(
              new FindAccumulatorValueQuery(
                  new LoadAccumulatorValueFilter(summary.getAccumulatorValueId())),
              ResponseTypes.instanceOf(AccumulatorValue.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate AccumulatorValue with id " + summary.getAccumulatorValueId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all AccumulatorValues
   *
   * @return List<AccumulatorValue>
   * @exception ProcessingException Thrown if any problems
   */
  public List<AccumulatorValue> getAllAccumulatorValue() throws ProcessingException {
    List<AccumulatorValue> list = null;

    try {
      CompletableFuture<List<AccumulatorValue>> futureList =
          queryGateway.query(
              new FindAllAccumulatorValueQuery(),
              ResponseTypes.multipleInstancesOf(AccumulatorValue.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all AccumulatorValue";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on AccumulatorValue
   *
   * @param command AssignValueToAccumulatorValueCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToAccumulatorValueCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAccumulatorValueId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    AccumulatorValueBusinessDelegate parentDelegate =
        AccumulatorValueBusinessDelegate.getAccumulatorValueInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AccumulatorValueValidator.getInstance().validate(command);

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
   * unAssign Value on AccumulatorValue
   *
   * @param command UnAssignValueFromAccumulatorValueCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromAccumulatorValueCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AccumulatorValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on AccumulatorValue";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add AccumulatorValue to AccumulatorValues
   *
   * @param command AssignAccumulatorValuesToAccumulatorValueCommand
   * @exception ProcessingException
   */
  public void addToAccumulatorValues(AssignAccumulatorValuesToAccumulatorValueCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getAccumulatorValueId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .AccumulatorValueBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.AccumulatorValueBusinessDelegate.getAccumulatorValueInstance();
    AccumulatorValueBusinessDelegate parentDelegate =
        AccumulatorValueBusinessDelegate.getAccumulatorValueInstance();
    UUID childId = command.getAddTo().getAccumulatorValueId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AccumulatorValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a AccumulatorValue as AccumulatorValues to AccumulatorValue";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove AccumulatorValue from AccumulatorValues
   *
   * @param command RemoveAccumulatorValuesFromAccumulatorValueCommand
   * @exception ProcessingException
   */
  public void removeFromAccumulatorValues(
      RemoveAccumulatorValuesFromAccumulatorValueCommand command) throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .AccumulatorValueBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.AccumulatorValueBusinessDelegate.getAccumulatorValueInstance();
    UUID childId = command.getRemoveFrom().getAccumulatorValueId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      AccumulatorValueValidator.getInstance().validate(command);

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
   * @return AccumulatorValue
   */
  private AccumulatorValue load(UUID id) throws ProcessingException {
    accumulatorValue =
        AccumulatorValueBusinessDelegate.getAccumulatorValueInstance()
            .getAccumulatorValue(new AccumulatorValueFetchOneSummary(id));
    return accumulatorValue;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private AccumulatorValue accumulatorValue = null;
  private static final Logger LOGGER =
      Logger.getLogger(AccumulatorValueBusinessDelegate.class.getName());
}
