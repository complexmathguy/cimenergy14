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
 * StringMeasurementValue business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of StringMeasurementValue related services in the case of a
 *       StringMeasurementValue business related service failing.
 *   <li>Exposes a simpler, uniform StringMeasurementValue interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill StringMeasurementValue
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class StringMeasurementValueBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public StringMeasurementValueBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * StringMeasurementValue Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return StringMeasurementValueBusinessDelegate
   */
  public static StringMeasurementValueBusinessDelegate getStringMeasurementValueInstance() {
    return (new StringMeasurementValueBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createStringMeasurementValue(
      CreateStringMeasurementValueCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getStringMeasurementValueId() == null)
        command.setStringMeasurementValueId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      StringMeasurementValueValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateStringMeasurementValueCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateStringMeasurementValueCommand of StringMeasurementValue is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create StringMeasurementValue - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateStringMeasurementValueCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateStringMeasurementValue(
      UpdateStringMeasurementValueCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      StringMeasurementValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateStringMeasurementValueCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save StringMeasurementValue - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteStringMeasurementValueCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteStringMeasurementValueCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      StringMeasurementValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteStringMeasurementValueCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete StringMeasurementValue using Id = "
              + command.getStringMeasurementValueId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the StringMeasurementValue via StringMeasurementValueFetchOneSummary
   *
   * @param summary StringMeasurementValueFetchOneSummary
   * @return StringMeasurementValueFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public StringMeasurementValue getStringMeasurementValue(
      StringMeasurementValueFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "StringMeasurementValueFetchOneSummary arg cannot be null");

    StringMeasurementValue entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      StringMeasurementValueValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a StringMeasurementValue
      // --------------------------------------
      CompletableFuture<StringMeasurementValue> futureEntity =
          queryGateway.query(
              new FindStringMeasurementValueQuery(
                  new LoadStringMeasurementValueFilter(summary.getStringMeasurementValueId())),
              ResponseTypes.instanceOf(StringMeasurementValue.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate StringMeasurementValue with id "
              + summary.getStringMeasurementValueId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all StringMeasurementValues
   *
   * @return List<StringMeasurementValue>
   * @exception ProcessingException Thrown if any problems
   */
  public List<StringMeasurementValue> getAllStringMeasurementValue() throws ProcessingException {
    List<StringMeasurementValue> list = null;

    try {
      CompletableFuture<List<StringMeasurementValue>> futureList =
          queryGateway.query(
              new FindAllStringMeasurementValueQuery(),
              ResponseTypes.multipleInstancesOf(StringMeasurementValue.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all StringMeasurementValue";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on StringMeasurementValue
   *
   * @param command AssignValueToStringMeasurementValueCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToStringMeasurementValueCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getStringMeasurementValueId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    StringMeasurementValueBusinessDelegate parentDelegate =
        StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      StringMeasurementValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Value on StringMeasurementValue
   *
   * @param command UnAssignValueFromStringMeasurementValueCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromStringMeasurementValueCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      StringMeasurementValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on StringMeasurementValue";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add StringMeasurementValue to StringMeasurementValues
   *
   * @param command AssignStringMeasurementValuesToStringMeasurementValueCommand
   * @exception ProcessingException
   */
  public void addToStringMeasurementValues(
      AssignStringMeasurementValuesToStringMeasurementValueCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getStringMeasurementValueId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .StringMeasurementValueBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.StringMeasurementValueBusinessDelegate
                .getStringMeasurementValueInstance();
    StringMeasurementValueBusinessDelegate parentDelegate =
        StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance();
    UUID childId = command.getAddTo().getStringMeasurementValueId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      StringMeasurementValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a StringMeasurementValue as StringMeasurementValues to StringMeasurementValue";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove StringMeasurementValue from StringMeasurementValues
   *
   * @param command RemoveStringMeasurementValuesFromStringMeasurementValueCommand
   * @exception ProcessingException
   */
  public void removeFromStringMeasurementValues(
      RemoveStringMeasurementValuesFromStringMeasurementValueCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .StringMeasurementValueBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.StringMeasurementValueBusinessDelegate
                .getStringMeasurementValueInstance();
    UUID childId = command.getRemoveFrom().getStringMeasurementValueId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      StringMeasurementValueValidator.getInstance().validate(command);

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
   * @return StringMeasurementValue
   */
  private StringMeasurementValue load(UUID id) throws ProcessingException {
    stringMeasurementValue =
        StringMeasurementValueBusinessDelegate.getStringMeasurementValueInstance()
            .getStringMeasurementValue(new StringMeasurementValueFetchOneSummary(id));
    return stringMeasurementValue;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private StringMeasurementValue stringMeasurementValue = null;
  private static final Logger LOGGER =
      Logger.getLogger(StringMeasurementValueBusinessDelegate.class.getName());
}
