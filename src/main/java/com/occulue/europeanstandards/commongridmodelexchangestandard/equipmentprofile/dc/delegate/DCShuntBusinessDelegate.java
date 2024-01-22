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
 * DCShunt business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DCShunt related services in the case of a DCShunt business
 *       related service failing.
 *   <li>Exposes a simpler, uniform DCShunt interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill DCShunt business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DCShuntBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DCShuntBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DCShunt Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DCShuntBusinessDelegate
   */
  public static DCShuntBusinessDelegate getDCShuntInstance() {
    return (new DCShuntBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDCShunt(CreateDCShuntCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDCShuntId() == null) command.setDCShuntId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCShuntValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDCShuntCommand - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDCShuntCommand of DCShunt is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DCShunt - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDCShuntCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDCShunt(UpdateDCShuntCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DCShuntValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDCShuntCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DCShunt - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDCShuntCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDCShuntCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCShuntValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDCShuntCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete DCShunt using Id = " + command.getDCShuntId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DCShunt via DCShuntFetchOneSummary
   *
   * @param summary DCShuntFetchOneSummary
   * @return DCShuntFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DCShunt getDCShunt(DCShuntFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DCShuntFetchOneSummary arg cannot be null");

    DCShunt entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DCShuntValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DCShunt
      // --------------------------------------
      CompletableFuture<DCShunt> futureEntity =
          queryGateway.query(
              new FindDCShuntQuery(new LoadDCShuntFilter(summary.getDCShuntId())),
              ResponseTypes.instanceOf(DCShunt.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate DCShunt with id " + summary.getDCShuntId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DCShunts
   *
   * @return List<DCShunt>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DCShunt> getAllDCShunt() throws ProcessingException {
    List<DCShunt> list = null;

    try {
      CompletableFuture<List<DCShunt>> futureList =
          queryGateway.query(
              new FindAllDCShuntQuery(), ResponseTypes.multipleInstancesOf(DCShunt.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DCShunt";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Capacitance on DCShunt
   *
   * @param command AssignCapacitanceToDCShuntCommand
   * @exception ProcessingException
   */
  public void assignCapacitance(AssignCapacitanceToDCShuntCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDCShuntId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CapacitanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CapacitanceBusinessDelegate.getCapacitanceInstance();
    DCShuntBusinessDelegate parentDelegate = DCShuntBusinessDelegate.getDCShuntInstance();
    UUID childId = command.getAssignment().getCapacitanceId();
    Capacitance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DCShuntValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Capacitance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Capacitance on DCShunt
   *
   * @param command UnAssignCapacitanceFromDCShuntCommand
   * @exception ProcessingException
   */
  public void unAssignCapacitance(UnAssignCapacitanceFromDCShuntCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCShuntValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Capacitance on DCShunt";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedUdc on DCShunt
   *
   * @param command AssignRatedUdcToDCShuntCommand
   * @exception ProcessingException
   */
  public void assignRatedUdc(AssignRatedUdcToDCShuntCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDCShuntId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    DCShuntBusinessDelegate parentDelegate = DCShuntBusinessDelegate.getDCShuntInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DCShuntValidator.getInstance().validate(command);

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
   * unAssign RatedUdc on DCShunt
   *
   * @param command UnAssignRatedUdcFromDCShuntCommand
   * @exception ProcessingException
   */
  public void unAssignRatedUdc(UnAssignRatedUdcFromDCShuntCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCShuntValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedUdc on DCShunt";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Resistance on DCShunt
   *
   * @param command AssignResistanceToDCShuntCommand
   * @exception ProcessingException
   */
  public void assignResistance(AssignResistanceToDCShuntCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDCShuntId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    DCShuntBusinessDelegate parentDelegate = DCShuntBusinessDelegate.getDCShuntInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DCShuntValidator.getInstance().validate(command);

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
   * unAssign Resistance on DCShunt
   *
   * @param command UnAssignResistanceFromDCShuntCommand
   * @exception ProcessingException
   */
  public void unAssignResistance(UnAssignResistanceFromDCShuntCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCShuntValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Resistance on DCShunt";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return DCShunt
   */
  private DCShunt load(UUID id) throws ProcessingException {
    dCShunt =
        DCShuntBusinessDelegate.getDCShuntInstance().getDCShunt(new DCShuntFetchOneSummary(id));
    return dCShunt;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DCShunt dCShunt = null;
  private static final Logger LOGGER = Logger.getLogger(DCShuntBusinessDelegate.class.getName());
}
