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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.validator.*;
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
 * VoltageAdjusterDynamics business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of VoltageAdjusterDynamics related services in the case of a
 *       VoltageAdjusterDynamics business related service failing.
 *   <li>Exposes a simpler, uniform VoltageAdjusterDynamics interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill VoltageAdjusterDynamics
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class VoltageAdjusterDynamicsBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public VoltageAdjusterDynamicsBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * VoltageAdjusterDynamics Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return VoltageAdjusterDynamicsBusinessDelegate
   */
  public static VoltageAdjusterDynamicsBusinessDelegate getVoltageAdjusterDynamicsInstance() {
    return (new VoltageAdjusterDynamicsBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createVoltageAdjusterDynamics(
      CreateVoltageAdjusterDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getVoltageAdjusterDynamicsId() == null)
        command.setVoltageAdjusterDynamicsId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageAdjusterDynamicsValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateVoltageAdjusterDynamicsCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateVoltageAdjusterDynamicsCommand of VoltageAdjusterDynamics is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create VoltageAdjusterDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateVoltageAdjusterDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateVoltageAdjusterDynamics(
      UpdateVoltageAdjusterDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      VoltageAdjusterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateVoltageAdjusterDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save VoltageAdjusterDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteVoltageAdjusterDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteVoltageAdjusterDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageAdjusterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteVoltageAdjusterDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete VoltageAdjusterDynamics using Id = "
              + command.getVoltageAdjusterDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the VoltageAdjusterDynamics via VoltageAdjusterDynamicsFetchOneSummary
   *
   * @param summary VoltageAdjusterDynamicsFetchOneSummary
   * @return VoltageAdjusterDynamicsFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public VoltageAdjusterDynamics getVoltageAdjusterDynamics(
      VoltageAdjusterDynamicsFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "VoltageAdjusterDynamicsFetchOneSummary arg cannot be null");

    VoltageAdjusterDynamics entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      VoltageAdjusterDynamicsValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a VoltageAdjusterDynamics
      // --------------------------------------
      CompletableFuture<VoltageAdjusterDynamics> futureEntity =
          queryGateway.query(
              new FindVoltageAdjusterDynamicsQuery(
                  new LoadVoltageAdjusterDynamicsFilter(summary.getVoltageAdjusterDynamicsId())),
              ResponseTypes.instanceOf(VoltageAdjusterDynamics.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate VoltageAdjusterDynamics with id "
              + summary.getVoltageAdjusterDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all VoltageAdjusterDynamicss
   *
   * @return List<VoltageAdjusterDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  public List<VoltageAdjusterDynamics> getAllVoltageAdjusterDynamics() throws ProcessingException {
    List<VoltageAdjusterDynamics> list = null;

    try {
      CompletableFuture<List<VoltageAdjusterDynamics>> futureList =
          queryGateway.query(
              new FindAllVoltageAdjusterDynamicsQuery(),
              ResponseTypes.multipleInstancesOf(VoltageAdjusterDynamics.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all VoltageAdjusterDynamics";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign VoltageAdjusterDynamics on VoltageAdjusterDynamics
   *
   * @param command AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsCommand
   * @exception ProcessingException
   */
  public void assignVoltageAdjusterDynamics(
      AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVoltageAdjusterDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
            .voltageadjusterdynamics.delegate.VoltageAdjusterDynamicsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
                .standardmodels.voltageadjusterdynamics.delegate
                .VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance();
    VoltageAdjusterDynamicsBusinessDelegate parentDelegate =
        VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance();
    UUID childId = command.getAssignment().getVoltageAdjusterDynamicsId();
    VoltageAdjusterDynamics child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VoltageAdjusterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get VoltageAdjusterDynamics using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign VoltageAdjusterDynamics on VoltageAdjusterDynamics
   *
   * @param command UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignVoltageAdjusterDynamics(
      UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageAdjusterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign VoltageAdjusterDynamics on VoltageAdjusterDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return VoltageAdjusterDynamics
   */
  private VoltageAdjusterDynamics load(UUID id) throws ProcessingException {
    voltageAdjusterDynamics =
        VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance()
            .getVoltageAdjusterDynamics(new VoltageAdjusterDynamicsFetchOneSummary(id));
    return voltageAdjusterDynamics;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private VoltageAdjusterDynamics voltageAdjusterDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(VoltageAdjusterDynamicsBusinessDelegate.class.getName());
}
