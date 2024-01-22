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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator.*;
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
 * PowerTransformerEnd business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PowerTransformerEnd related services in the case of a
 *       PowerTransformerEnd business related service failing.
 *   <li>Exposes a simpler, uniform PowerTransformerEnd interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PowerTransformerEnd
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PowerTransformerEndBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PowerTransformerEndBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PowerTransformerEnd Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PowerTransformerEndBusinessDelegate
   */
  public static PowerTransformerEndBusinessDelegate getPowerTransformerEndInstance() {
    return (new PowerTransformerEndBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPowerTransformerEnd(CreatePowerTransformerEndCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPowerTransformerEndId() == null)
        command.setPowerTransformerEndId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePowerTransformerEndCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePowerTransformerEndCommand of PowerTransformerEnd is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PowerTransformerEnd - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePowerTransformerEndCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePowerTransformerEnd(UpdatePowerTransformerEndCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePowerTransformerEndCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PowerTransformerEnd - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePowerTransformerEndCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePowerTransformerEndCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePowerTransformerEndCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PowerTransformerEnd using Id = " + command.getPowerTransformerEndId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PowerTransformerEnd via PowerTransformerEndFetchOneSummary
   *
   * @param summary PowerTransformerEndFetchOneSummary
   * @return PowerTransformerEndFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PowerTransformerEnd getPowerTransformerEnd(PowerTransformerEndFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("PowerTransformerEndFetchOneSummary arg cannot be null");

    PowerTransformerEnd entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PowerTransformerEnd
      // --------------------------------------
      CompletableFuture<PowerTransformerEnd> futureEntity =
          queryGateway.query(
              new FindPowerTransformerEndQuery(
                  new LoadPowerTransformerEndFilter(summary.getPowerTransformerEndId())),
              ResponseTypes.instanceOf(PowerTransformerEnd.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PowerTransformerEnd with id " + summary.getPowerTransformerEndId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PowerTransformerEnds
   *
   * @return List<PowerTransformerEnd>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PowerTransformerEnd> getAllPowerTransformerEnd() throws ProcessingException {
    List<PowerTransformerEnd> list = null;

    try {
      CompletableFuture<List<PowerTransformerEnd>> futureList =
          queryGateway.query(
              new FindAllPowerTransformerEndQuery(),
              ResponseTypes.multipleInstancesOf(PowerTransformerEnd.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PowerTransformerEnd";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign B on PowerTransformerEnd
   *
   * @param command AssignBToPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignB(AssignBToPowerTransformerEndCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SusceptanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SusceptanceBusinessDelegate.getSusceptanceInstance();
    PowerTransformerEndBusinessDelegate parentDelegate =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getAssignment().getSusceptanceId();
    Susceptance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Susceptance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign B on PowerTransformerEnd
   *
   * @param command UnAssignBFromPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignB(UnAssignBFromPowerTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B on PowerTransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign B0 on PowerTransformerEnd
   *
   * @param command AssignB0ToPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignB0(AssignB0ToPowerTransformerEndCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SusceptanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SusceptanceBusinessDelegate.getSusceptanceInstance();
    PowerTransformerEndBusinessDelegate parentDelegate =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getAssignment().getSusceptanceId();
    Susceptance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Susceptance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign B0 on PowerTransformerEnd
   *
   * @param command UnAssignB0FromPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignB0(UnAssignB0FromPowerTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B0 on PowerTransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign G on PowerTransformerEnd
   *
   * @param command AssignGToPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignG(AssignGToPowerTransformerEndCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ConductanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ConductanceBusinessDelegate.getConductanceInstance();
    PowerTransformerEndBusinessDelegate parentDelegate =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getAssignment().getConductanceId();
    Conductance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Conductance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign G on PowerTransformerEnd
   *
   * @param command UnAssignGFromPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignG(UnAssignGFromPowerTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign G on PowerTransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign G0 on PowerTransformerEnd
   *
   * @param command AssignG0ToPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignG0(AssignG0ToPowerTransformerEndCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ConductanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ConductanceBusinessDelegate.getConductanceInstance();
    PowerTransformerEndBusinessDelegate parentDelegate =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getAssignment().getConductanceId();
    Conductance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Conductance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign G0 on PowerTransformerEnd
   *
   * @param command UnAssignG0FromPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignG0(UnAssignG0FromPowerTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign G0 on PowerTransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PhaseAngleClock on PowerTransformerEnd
   *
   * @param command AssignPhaseAngleClockToPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignPhaseAngleClock(AssignPhaseAngleClockToPowerTransformerEndCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    PowerTransformerEndBusinessDelegate parentDelegate =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

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
   * unAssign PhaseAngleClock on PowerTransformerEnd
   *
   * @param command UnAssignPhaseAngleClockFromPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignPhaseAngleClock(UnAssignPhaseAngleClockFromPowerTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PhaseAngleClock on PowerTransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R on PowerTransformerEnd
   *
   * @param command AssignRToPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignR(AssignRToPowerTransformerEndCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    PowerTransformerEndBusinessDelegate parentDelegate =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

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
   * unAssign R on PowerTransformerEnd
   *
   * @param command UnAssignRFromPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignR(UnAssignRFromPowerTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R on PowerTransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R0 on PowerTransformerEnd
   *
   * @param command AssignR0ToPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignR0(AssignR0ToPowerTransformerEndCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    PowerTransformerEndBusinessDelegate parentDelegate =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

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
   * unAssign R0 on PowerTransformerEnd
   *
   * @param command UnAssignR0FromPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignR0(UnAssignR0FromPowerTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R0 on PowerTransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedS on PowerTransformerEnd
   *
   * @param command AssignRatedSToPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignRatedS(AssignRatedSToPowerTransformerEndCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ApparentPowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ApparentPowerBusinessDelegate.getApparentPowerInstance();
    PowerTransformerEndBusinessDelegate parentDelegate =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getAssignment().getApparentPowerId();
    ApparentPower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ApparentPower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign RatedS on PowerTransformerEnd
   *
   * @param command UnAssignRatedSFromPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignRatedS(UnAssignRatedSFromPowerTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedS on PowerTransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedU on PowerTransformerEnd
   *
   * @param command AssignRatedUToPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignRatedU(AssignRatedUToPowerTransformerEndCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .VoltageBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .VoltageBusinessDelegate.getVoltageInstance();
    PowerTransformerEndBusinessDelegate parentDelegate =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getAssignment().getVoltageId();
    Voltage child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

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
   * unAssign RatedU on PowerTransformerEnd
   *
   * @param command UnAssignRatedUFromPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignRatedU(UnAssignRatedUFromPowerTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedU on PowerTransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X on PowerTransformerEnd
   *
   * @param command AssignXToPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignX(AssignXToPowerTransformerEndCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    PowerTransformerEndBusinessDelegate parentDelegate =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Reactance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign X on PowerTransformerEnd
   *
   * @param command UnAssignXFromPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignX(UnAssignXFromPowerTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X on PowerTransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X0 on PowerTransformerEnd
   *
   * @param command AssignX0ToPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void assignX0(AssignX0ToPowerTransformerEndCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPowerTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    PowerTransformerEndBusinessDelegate parentDelegate =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Reactance using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign X0 on PowerTransformerEnd
   *
   * @param command UnAssignX0FromPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void unAssignX0(UnAssignX0FromPowerTransformerEndCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X0 on PowerTransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add PowerTransformerEnd to PowerTransformerEnd
   *
   * @param command AssignPowerTransformerEndToPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void addToPowerTransformerEnd(
      AssignPowerTransformerEndToPowerTransformerEndCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getPowerTransformerEndId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .PowerTransformerEndBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    PowerTransformerEndBusinessDelegate parentDelegate =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getAddTo().getPowerTransformerEndId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a PowerTransformerEnd as PowerTransformerEnd to PowerTransformerEnd";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove PowerTransformerEnd from PowerTransformerEnd
   *
   * @param command RemovePowerTransformerEndFromPowerTransformerEndCommand
   * @exception ProcessingException
   */
  public void removeFromPowerTransformerEnd(
      RemovePowerTransformerEndFromPowerTransformerEndCommand command) throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .PowerTransformerEndBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();
    UUID childId = command.getRemoveFrom().getPowerTransformerEndId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PowerTransformerEndValidator.getInstance().validate(command);

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
   * @return PowerTransformerEnd
   */
  private PowerTransformerEnd load(UUID id) throws ProcessingException {
    powerTransformerEnd =
        PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance()
            .getPowerTransformerEnd(new PowerTransformerEndFetchOneSummary(id));
    return powerTransformerEnd;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PowerTransformerEnd powerTransformerEnd = null;
  private static final Logger LOGGER =
      Logger.getLogger(PowerTransformerEndBusinessDelegate.class.getName());
}
