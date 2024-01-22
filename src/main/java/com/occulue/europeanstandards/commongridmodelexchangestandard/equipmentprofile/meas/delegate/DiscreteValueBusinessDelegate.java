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
 * DiscreteValue business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DiscreteValue related services in the case of a DiscreteValue
 *       business related service failing.
 *   <li>Exposes a simpler, uniform DiscreteValue interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill DiscreteValue business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DiscreteValueBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DiscreteValueBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DiscreteValue Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DiscreteValueBusinessDelegate
   */
  public static DiscreteValueBusinessDelegate getDiscreteValueInstance() {
    return (new DiscreteValueBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDiscreteValue(CreateDiscreteValueCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDiscreteValueId() == null) command.setDiscreteValueId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscreteValueValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDiscreteValueCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDiscreteValueCommand of DiscreteValue is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DiscreteValue - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDiscreteValueCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDiscreteValue(UpdateDiscreteValueCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DiscreteValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDiscreteValueCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DiscreteValue - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDiscreteValueCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDiscreteValueCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscreteValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDiscreteValueCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete DiscreteValue using Id = " + command.getDiscreteValueId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DiscreteValue via DiscreteValueFetchOneSummary
   *
   * @param summary DiscreteValueFetchOneSummary
   * @return DiscreteValueFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DiscreteValue getDiscreteValue(DiscreteValueFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DiscreteValueFetchOneSummary arg cannot be null");

    DiscreteValue entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DiscreteValueValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DiscreteValue
      // --------------------------------------
      CompletableFuture<DiscreteValue> futureEntity =
          queryGateway.query(
              new FindDiscreteValueQuery(new LoadDiscreteValueFilter(summary.getDiscreteValueId())),
              ResponseTypes.instanceOf(DiscreteValue.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate DiscreteValue with id " + summary.getDiscreteValueId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DiscreteValues
   *
   * @return List<DiscreteValue>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DiscreteValue> getAllDiscreteValue() throws ProcessingException {
    List<DiscreteValue> list = null;

    try {
      CompletableFuture<List<DiscreteValue>> futureList =
          queryGateway.query(
              new FindAllDiscreteValueQuery(),
              ResponseTypes.multipleInstancesOf(DiscreteValue.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DiscreteValue";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on DiscreteValue
   *
   * @param command AssignValueToDiscreteValueCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToDiscreteValueCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscreteValueId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    DiscreteValueBusinessDelegate parentDelegate =
        DiscreteValueBusinessDelegate.getDiscreteValueInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscreteValueValidator.getInstance().validate(command);

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
   * unAssign Value on DiscreteValue
   *
   * @param command UnAssignValueFromDiscreteValueCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromDiscreteValueCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscreteValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on DiscreteValue";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add DiscreteValue to DiscreteValues
   *
   * @param command AssignDiscreteValuesToDiscreteValueCommand
   * @exception ProcessingException
   */
  public void addToDiscreteValues(AssignDiscreteValuesToDiscreteValueCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getDiscreteValueId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .DiscreteValueBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.DiscreteValueBusinessDelegate.getDiscreteValueInstance();
    DiscreteValueBusinessDelegate parentDelegate =
        DiscreteValueBusinessDelegate.getDiscreteValueInstance();
    UUID childId = command.getAddTo().getDiscreteValueId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscreteValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a DiscreteValue as DiscreteValues to DiscreteValue";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove DiscreteValue from DiscreteValues
   *
   * @param command RemoveDiscreteValuesFromDiscreteValueCommand
   * @exception ProcessingException
   */
  public void removeFromDiscreteValues(RemoveDiscreteValuesFromDiscreteValueCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .DiscreteValueBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.DiscreteValueBusinessDelegate.getDiscreteValueInstance();
    UUID childId = command.getRemoveFrom().getDiscreteValueId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscreteValueValidator.getInstance().validate(command);

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
   * @return DiscreteValue
   */
  private DiscreteValue load(UUID id) throws ProcessingException {
    discreteValue =
        DiscreteValueBusinessDelegate.getDiscreteValueInstance()
            .getDiscreteValue(new DiscreteValueFetchOneSummary(id));
    return discreteValue;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DiscreteValue discreteValue = null;
  private static final Logger LOGGER =
      Logger.getLogger(DiscreteValueBusinessDelegate.class.getName());
}
