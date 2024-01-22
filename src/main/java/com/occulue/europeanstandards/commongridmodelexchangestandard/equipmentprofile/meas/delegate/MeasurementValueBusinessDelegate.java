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
 * MeasurementValue business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of MeasurementValue related services in the case of a
 *       MeasurementValue business related service failing.
 *   <li>Exposes a simpler, uniform MeasurementValue interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill MeasurementValue business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class MeasurementValueBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public MeasurementValueBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * MeasurementValue Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return MeasurementValueBusinessDelegate
   */
  public static MeasurementValueBusinessDelegate getMeasurementValueInstance() {
    return (new MeasurementValueBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createMeasurementValue(CreateMeasurementValueCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getMeasurementValueId() == null) command.setMeasurementValueId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      MeasurementValueValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateMeasurementValueCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateMeasurementValueCommand of MeasurementValue is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create MeasurementValue - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateMeasurementValueCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateMeasurementValue(UpdateMeasurementValueCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      MeasurementValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateMeasurementValueCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save MeasurementValue - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteMeasurementValueCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteMeasurementValueCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MeasurementValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteMeasurementValueCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete MeasurementValue using Id = " + command.getMeasurementValueId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the MeasurementValue via MeasurementValueFetchOneSummary
   *
   * @param summary MeasurementValueFetchOneSummary
   * @return MeasurementValueFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public MeasurementValue getMeasurementValue(MeasurementValueFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("MeasurementValueFetchOneSummary arg cannot be null");

    MeasurementValue entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      MeasurementValueValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a MeasurementValue
      // --------------------------------------
      CompletableFuture<MeasurementValue> futureEntity =
          queryGateway.query(
              new FindMeasurementValueQuery(
                  new LoadMeasurementValueFilter(summary.getMeasurementValueId())),
              ResponseTypes.instanceOf(MeasurementValue.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate MeasurementValue with id " + summary.getMeasurementValueId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all MeasurementValues
   *
   * @return List<MeasurementValue>
   * @exception ProcessingException Thrown if any problems
   */
  public List<MeasurementValue> getAllMeasurementValue() throws ProcessingException {
    List<MeasurementValue> list = null;

    try {
      CompletableFuture<List<MeasurementValue>> futureList =
          queryGateway.query(
              new FindAllMeasurementValueQuery(),
              ResponseTypes.multipleInstancesOf(MeasurementValue.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all MeasurementValue";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign SensorAccuracy on MeasurementValue
   *
   * @param command AssignSensorAccuracyToMeasurementValueCommand
   * @exception ProcessingException
   */
  public void assignSensorAccuracy(AssignSensorAccuracyToMeasurementValueCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMeasurementValueId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    MeasurementValueBusinessDelegate parentDelegate =
        MeasurementValueBusinessDelegate.getMeasurementValueInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MeasurementValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PerCent using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SensorAccuracy on MeasurementValue
   *
   * @param command UnAssignSensorAccuracyFromMeasurementValueCommand
   * @exception ProcessingException
   */
  public void unAssignSensorAccuracy(UnAssignSensorAccuracyFromMeasurementValueCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MeasurementValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SensorAccuracy on MeasurementValue";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign TimeStamp on MeasurementValue
   *
   * @param command AssignTimeStampToMeasurementValueCommand
   * @exception ProcessingException
   */
  public void assignTimeStamp(AssignTimeStampToMeasurementValueCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMeasurementValueId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .DateTimeBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .DateTimeBusinessDelegate.getDateTimeInstance();
    MeasurementValueBusinessDelegate parentDelegate =
        MeasurementValueBusinessDelegate.getMeasurementValueInstance();
    UUID childId = command.getAssignment().getDateTimeId();
    DateTime child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MeasurementValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get DateTime using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign TimeStamp on MeasurementValue
   *
   * @param command UnAssignTimeStampFromMeasurementValueCommand
   * @exception ProcessingException
   */
  public void unAssignTimeStamp(UnAssignTimeStampFromMeasurementValueCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MeasurementValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign TimeStamp on MeasurementValue";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add MeasurementValue to MeasurementValues
   *
   * @param command AssignMeasurementValuesToMeasurementValueCommand
   * @exception ProcessingException
   */
  public void addToMeasurementValues(AssignMeasurementValuesToMeasurementValueCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getMeasurementValueId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .MeasurementValueBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.MeasurementValueBusinessDelegate.getMeasurementValueInstance();
    MeasurementValueBusinessDelegate parentDelegate =
        MeasurementValueBusinessDelegate.getMeasurementValueInstance();
    UUID childId = command.getAddTo().getMeasurementValueId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MeasurementValueValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a MeasurementValue as MeasurementValues to MeasurementValue";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove MeasurementValue from MeasurementValues
   *
   * @param command RemoveMeasurementValuesFromMeasurementValueCommand
   * @exception ProcessingException
   */
  public void removeFromMeasurementValues(
      RemoveMeasurementValuesFromMeasurementValueCommand command) throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .MeasurementValueBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.MeasurementValueBusinessDelegate.getMeasurementValueInstance();
    UUID childId = command.getRemoveFrom().getMeasurementValueId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      MeasurementValueValidator.getInstance().validate(command);

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
   * @return MeasurementValue
   */
  private MeasurementValue load(UUID id) throws ProcessingException {
    measurementValue =
        MeasurementValueBusinessDelegate.getMeasurementValueInstance()
            .getMeasurementValue(new MeasurementValueFetchOneSummary(id));
    return measurementValue;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private MeasurementValue measurementValue = null;
  private static final Logger LOGGER =
      Logger.getLogger(MeasurementValueBusinessDelegate.class.getName());
}
