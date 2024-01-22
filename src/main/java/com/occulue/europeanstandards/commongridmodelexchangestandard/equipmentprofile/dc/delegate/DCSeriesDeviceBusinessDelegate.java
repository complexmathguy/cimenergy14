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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator.*;
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
 * DCSeriesDevice business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DCSeriesDevice related services in the case of a DCSeriesDevice
 *       business related service failing.
 *   <li>Exposes a simpler, uniform DCSeriesDevice interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill DCSeriesDevice business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DCSeriesDeviceBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DCSeriesDeviceBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DCSeriesDevice Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DCSeriesDeviceBusinessDelegate
   */
  public static DCSeriesDeviceBusinessDelegate getDCSeriesDeviceInstance() {
    return (new DCSeriesDeviceBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDCSeriesDevice(CreateDCSeriesDeviceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDCSeriesDeviceId() == null) command.setDCSeriesDeviceId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCSeriesDeviceValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDCSeriesDeviceCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDCSeriesDeviceCommand of DCSeriesDevice is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DCSeriesDevice - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDCSeriesDeviceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDCSeriesDevice(UpdateDCSeriesDeviceCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DCSeriesDeviceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDCSeriesDeviceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DCSeriesDevice - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDCSeriesDeviceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDCSeriesDeviceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCSeriesDeviceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDCSeriesDeviceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete DCSeriesDevice using Id = " + command.getDCSeriesDeviceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DCSeriesDevice via DCSeriesDeviceFetchOneSummary
   *
   * @param summary DCSeriesDeviceFetchOneSummary
   * @return DCSeriesDeviceFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DCSeriesDevice getDCSeriesDevice(DCSeriesDeviceFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DCSeriesDeviceFetchOneSummary arg cannot be null");

    DCSeriesDevice entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DCSeriesDeviceValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DCSeriesDevice
      // --------------------------------------
      CompletableFuture<DCSeriesDevice> futureEntity =
          queryGateway.query(
              new FindDCSeriesDeviceQuery(
                  new LoadDCSeriesDeviceFilter(summary.getDCSeriesDeviceId())),
              ResponseTypes.instanceOf(DCSeriesDevice.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate DCSeriesDevice with id " + summary.getDCSeriesDeviceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DCSeriesDevices
   *
   * @return List<DCSeriesDevice>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DCSeriesDevice> getAllDCSeriesDevice() throws ProcessingException {
    List<DCSeriesDevice> list = null;

    try {
      CompletableFuture<List<DCSeriesDevice>> futureList =
          queryGateway.query(
              new FindAllDCSeriesDeviceQuery(),
              ResponseTypes.multipleInstancesOf(DCSeriesDevice.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DCSeriesDevice";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Inductance on DCSeriesDevice
   *
   * @param command AssignInductanceToDCSeriesDeviceCommand
   * @exception ProcessingException
   */
  public void assignInductance(AssignInductanceToDCSeriesDeviceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDCSeriesDeviceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .InductanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .InductanceBusinessDelegate.getInductanceInstance();
    DCSeriesDeviceBusinessDelegate parentDelegate =
        DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance();
    UUID childId = command.getAssignment().getInductanceId();
    Inductance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DCSeriesDeviceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Inductance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Inductance on DCSeriesDevice
   *
   * @param command UnAssignInductanceFromDCSeriesDeviceCommand
   * @exception ProcessingException
   */
  public void unAssignInductance(UnAssignInductanceFromDCSeriesDeviceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCSeriesDeviceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Inductance on DCSeriesDevice";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedUdc on DCSeriesDevice
   *
   * @param command AssignRatedUdcToDCSeriesDeviceCommand
   * @exception ProcessingException
   */
  public void assignRatedUdc(AssignRatedUdcToDCSeriesDeviceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDCSeriesDeviceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    DCSeriesDeviceBusinessDelegate parentDelegate =
        DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DCSeriesDeviceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Voltage using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign RatedUdc on DCSeriesDevice
   *
   * @param command UnAssignRatedUdcFromDCSeriesDeviceCommand
   * @exception ProcessingException
   */
  public void unAssignRatedUdc(UnAssignRatedUdcFromDCSeriesDeviceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCSeriesDeviceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedUdc on DCSeriesDevice";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Resistance on DCSeriesDevice
   *
   * @param command AssignResistanceToDCSeriesDeviceCommand
   * @exception ProcessingException
   */
  public void assignResistance(AssignResistanceToDCSeriesDeviceCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDCSeriesDeviceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    DCSeriesDeviceBusinessDelegate parentDelegate =
        DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DCSeriesDeviceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Resistance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Resistance on DCSeriesDevice
   *
   * @param command UnAssignResistanceFromDCSeriesDeviceCommand
   * @exception ProcessingException
   */
  public void unAssignResistance(UnAssignResistanceFromDCSeriesDeviceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCSeriesDeviceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Resistance on DCSeriesDevice";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return DCSeriesDevice
   */
  private DCSeriesDevice load(UUID id) throws ProcessingException {
    dCSeriesDevice =
        DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance()
            .getDCSeriesDevice(new DCSeriesDeviceFetchOneSummary(id));
    return dCSeriesDevice;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DCSeriesDevice dCSeriesDevice = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCSeriesDeviceBusinessDelegate.class.getName());
}
