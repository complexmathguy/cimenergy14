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
 * Measurement business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Measurement related services in the case of a Measurement
 *       business related service failing.
 *   <li>Exposes a simpler, uniform Measurement interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Measurement business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class MeasurementBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public MeasurementBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Measurement Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return MeasurementBusinessDelegate
   */
  public static MeasurementBusinessDelegate getMeasurementInstance() {
    return (new MeasurementBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createMeasurement(CreateMeasurementCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getMeasurementId() == null) command.setMeasurementId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      MeasurementValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateMeasurementCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateMeasurementCommand of Measurement is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Measurement - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateMeasurementCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateMeasurement(UpdateMeasurementCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      MeasurementValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateMeasurementCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Measurement - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteMeasurementCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteMeasurementCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MeasurementValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteMeasurementCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Measurement using Id = " + command.getMeasurementId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Measurement via MeasurementFetchOneSummary
   *
   * @param summary MeasurementFetchOneSummary
   * @return MeasurementFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Measurement getMeasurement(MeasurementFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("MeasurementFetchOneSummary arg cannot be null");

    Measurement entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      MeasurementValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Measurement
      // --------------------------------------
      CompletableFuture<Measurement> futureEntity =
          queryGateway.query(
              new FindMeasurementQuery(new LoadMeasurementFilter(summary.getMeasurementId())),
              ResponseTypes.instanceOf(Measurement.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Measurement with id " + summary.getMeasurementId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Measurements
   *
   * @return List<Measurement>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Measurement> getAllMeasurement() throws ProcessingException {
    List<Measurement> list = null;

    try {
      CompletableFuture<List<Measurement>> futureList =
          queryGateway.query(
              new FindAllMeasurementQuery(), ResponseTypes.multipleInstancesOf(Measurement.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Measurement";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign MeasurementType on Measurement
   *
   * @param command AssignMeasurementTypeToMeasurementCommand
   * @exception ProcessingException
   */
  public void assignMeasurementType(AssignMeasurementTypeToMeasurementCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMeasurementId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    MeasurementBusinessDelegate parentDelegate =
        MeasurementBusinessDelegate.getMeasurementInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MeasurementValidator.getInstance().validate(command);

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
   * unAssign MeasurementType on Measurement
   *
   * @param command UnAssignMeasurementTypeFromMeasurementCommand
   * @exception ProcessingException
   */
  public void unAssignMeasurementType(UnAssignMeasurementTypeFromMeasurementCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MeasurementValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign MeasurementType on Measurement";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add Measurement to Measurements
   *
   * @param command AssignMeasurementsToMeasurementCommand
   * @exception ProcessingException
   */
  public void addToMeasurements(AssignMeasurementsToMeasurementCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getMeasurementId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .MeasurementBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.MeasurementBusinessDelegate.getMeasurementInstance();
    MeasurementBusinessDelegate parentDelegate =
        MeasurementBusinessDelegate.getMeasurementInstance();
    UUID childId = command.getAddTo().getMeasurementId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MeasurementValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a Measurement as Measurements to Measurement";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove Measurement from Measurements
   *
   * @param command RemoveMeasurementsFromMeasurementCommand
   * @exception ProcessingException
   */
  public void removeFromMeasurements(RemoveMeasurementsFromMeasurementCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .MeasurementBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.MeasurementBusinessDelegate.getMeasurementInstance();
    UUID childId = command.getRemoveFrom().getMeasurementId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      MeasurementValidator.getInstance().validate(command);

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
   * @return Measurement
   */
  private Measurement load(UUID id) throws ProcessingException {
    measurement =
        MeasurementBusinessDelegate.getMeasurementInstance()
            .getMeasurement(new MeasurementFetchOneSummary(id));
    return measurement;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Measurement measurement = null;
  private static final Logger LOGGER =
      Logger.getLogger(MeasurementBusinessDelegate.class.getName());
}
