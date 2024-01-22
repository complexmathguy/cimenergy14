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
 * MutualCoupling business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of MutualCoupling related services in the case of a MutualCoupling
 *       business related service failing.
 *   <li>Exposes a simpler, uniform MutualCoupling interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill MutualCoupling business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class MutualCouplingBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public MutualCouplingBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * MutualCoupling Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return MutualCouplingBusinessDelegate
   */
  public static MutualCouplingBusinessDelegate getMutualCouplingInstance() {
    return (new MutualCouplingBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createMutualCoupling(CreateMutualCouplingCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getMutualCouplingId() == null) command.setMutualCouplingId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateMutualCouplingCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateMutualCouplingCommand of MutualCoupling is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create MutualCoupling - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateMutualCouplingCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateMutualCoupling(UpdateMutualCouplingCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateMutualCouplingCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save MutualCoupling - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteMutualCouplingCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteMutualCouplingCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteMutualCouplingCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete MutualCoupling using Id = " + command.getMutualCouplingId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the MutualCoupling via MutualCouplingFetchOneSummary
   *
   * @param summary MutualCouplingFetchOneSummary
   * @return MutualCouplingFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public MutualCoupling getMutualCoupling(MutualCouplingFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("MutualCouplingFetchOneSummary arg cannot be null");

    MutualCoupling entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a MutualCoupling
      // --------------------------------------
      CompletableFuture<MutualCoupling> futureEntity =
          queryGateway.query(
              new FindMutualCouplingQuery(
                  new LoadMutualCouplingFilter(summary.getMutualCouplingId())),
              ResponseTypes.instanceOf(MutualCoupling.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate MutualCoupling with id " + summary.getMutualCouplingId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all MutualCouplings
   *
   * @return List<MutualCoupling>
   * @exception ProcessingException Thrown if any problems
   */
  public List<MutualCoupling> getAllMutualCoupling() throws ProcessingException {
    List<MutualCoupling> list = null;

    try {
      CompletableFuture<List<MutualCoupling>> futureList =
          queryGateway.query(
              new FindAllMutualCouplingQuery(),
              ResponseTypes.multipleInstancesOf(MutualCoupling.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all MutualCoupling";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign B0ch on MutualCoupling
   *
   * @param command AssignB0chToMutualCouplingCommand
   * @exception ProcessingException
   */
  public void assignB0ch(AssignB0chToMutualCouplingCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMutualCouplingId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SusceptanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SusceptanceBusinessDelegate.getSusceptanceInstance();
    MutualCouplingBusinessDelegate parentDelegate =
        MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    UUID childId = command.getAssignment().getSusceptanceId();
    Susceptance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

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
   * unAssign B0ch on MutualCoupling
   *
   * @param command UnAssignB0chFromMutualCouplingCommand
   * @exception ProcessingException
   */
  public void unAssignB0ch(UnAssignB0chFromMutualCouplingCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B0ch on MutualCoupling";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Distance11 on MutualCoupling
   *
   * @param command AssignDistance11ToMutualCouplingCommand
   * @exception ProcessingException
   */
  public void assignDistance11(AssignDistance11ToMutualCouplingCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMutualCouplingId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    MutualCouplingBusinessDelegate parentDelegate =
        MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Length using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Distance11 on MutualCoupling
   *
   * @param command UnAssignDistance11FromMutualCouplingCommand
   * @exception ProcessingException
   */
  public void unAssignDistance11(UnAssignDistance11FromMutualCouplingCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Distance11 on MutualCoupling";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Distance12 on MutualCoupling
   *
   * @param command AssignDistance12ToMutualCouplingCommand
   * @exception ProcessingException
   */
  public void assignDistance12(AssignDistance12ToMutualCouplingCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMutualCouplingId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    MutualCouplingBusinessDelegate parentDelegate =
        MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Length using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Distance12 on MutualCoupling
   *
   * @param command UnAssignDistance12FromMutualCouplingCommand
   * @exception ProcessingException
   */
  public void unAssignDistance12(UnAssignDistance12FromMutualCouplingCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Distance12 on MutualCoupling";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Distance21 on MutualCoupling
   *
   * @param command AssignDistance21ToMutualCouplingCommand
   * @exception ProcessingException
   */
  public void assignDistance21(AssignDistance21ToMutualCouplingCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMutualCouplingId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    MutualCouplingBusinessDelegate parentDelegate =
        MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Length using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Distance21 on MutualCoupling
   *
   * @param command UnAssignDistance21FromMutualCouplingCommand
   * @exception ProcessingException
   */
  public void unAssignDistance21(UnAssignDistance21FromMutualCouplingCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Distance21 on MutualCoupling";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Distance22 on MutualCoupling
   *
   * @param command AssignDistance22ToMutualCouplingCommand
   * @exception ProcessingException
   */
  public void assignDistance22(AssignDistance22ToMutualCouplingCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMutualCouplingId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .LengthBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .LengthBusinessDelegate.getLengthInstance();
    MutualCouplingBusinessDelegate parentDelegate =
        MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    UUID childId = command.getAssignment().getLengthId();
    Length child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Length using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Distance22 on MutualCoupling
   *
   * @param command UnAssignDistance22FromMutualCouplingCommand
   * @exception ProcessingException
   */
  public void unAssignDistance22(UnAssignDistance22FromMutualCouplingCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Distance22 on MutualCoupling";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign G0ch on MutualCoupling
   *
   * @param command AssignG0chToMutualCouplingCommand
   * @exception ProcessingException
   */
  public void assignG0ch(AssignG0chToMutualCouplingCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMutualCouplingId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ConductanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ConductanceBusinessDelegate.getConductanceInstance();
    MutualCouplingBusinessDelegate parentDelegate =
        MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    UUID childId = command.getAssignment().getConductanceId();
    Conductance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

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
   * unAssign G0ch on MutualCoupling
   *
   * @param command UnAssignG0chFromMutualCouplingCommand
   * @exception ProcessingException
   */
  public void unAssignG0ch(UnAssignG0chFromMutualCouplingCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign G0ch on MutualCoupling";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R0 on MutualCoupling
   *
   * @param command AssignR0ToMutualCouplingCommand
   * @exception ProcessingException
   */
  public void assignR0(AssignR0ToMutualCouplingCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMutualCouplingId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    MutualCouplingBusinessDelegate parentDelegate =
        MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

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
   * unAssign R0 on MutualCoupling
   *
   * @param command UnAssignR0FromMutualCouplingCommand
   * @exception ProcessingException
   */
  public void unAssignR0(UnAssignR0FromMutualCouplingCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R0 on MutualCoupling";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X0 on MutualCoupling
   *
   * @param command AssignX0ToMutualCouplingCommand
   * @exception ProcessingException
   */
  public void assignX0(AssignX0ToMutualCouplingCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getMutualCouplingId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    MutualCouplingBusinessDelegate parentDelegate =
        MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

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
   * unAssign X0 on MutualCoupling
   *
   * @param command UnAssignX0FromMutualCouplingCommand
   * @exception ProcessingException
   */
  public void unAssignX0(UnAssignX0FromMutualCouplingCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X0 on MutualCoupling";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add MutualCoupling to HasSecondMutualCoupling
   *
   * @param command AssignHasSecondMutualCouplingToMutualCouplingCommand
   * @exception ProcessingException
   */
  public void addToHasSecondMutualCoupling(
      AssignHasSecondMutualCouplingToMutualCouplingCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getMutualCouplingId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .MutualCouplingBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    MutualCouplingBusinessDelegate parentDelegate =
        MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    UUID childId = command.getAddTo().getMutualCouplingId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a MutualCoupling as HasSecondMutualCoupling to MutualCoupling";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove MutualCoupling from HasSecondMutualCoupling
   *
   * @param command RemoveHasSecondMutualCouplingFromMutualCouplingCommand
   * @exception ProcessingException
   */
  public void removeFromHasSecondMutualCoupling(
      RemoveHasSecondMutualCouplingFromMutualCouplingCommand command) throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .MutualCouplingBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    UUID childId = command.getRemoveFrom().getMutualCouplingId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

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
   * add MutualCoupling to HasFirstMutualCoupling
   *
   * @param command AssignHasFirstMutualCouplingToMutualCouplingCommand
   * @exception ProcessingException
   */
  public void addToHasFirstMutualCoupling(
      AssignHasFirstMutualCouplingToMutualCouplingCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getMutualCouplingId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .MutualCouplingBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    MutualCouplingBusinessDelegate parentDelegate =
        MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    UUID childId = command.getAddTo().getMutualCouplingId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a MutualCoupling as HasFirstMutualCoupling to MutualCoupling";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove MutualCoupling from HasFirstMutualCoupling
   *
   * @param command RemoveHasFirstMutualCouplingFromMutualCouplingCommand
   * @exception ProcessingException
   */
  public void removeFromHasFirstMutualCoupling(
      RemoveHasFirstMutualCouplingFromMutualCouplingCommand command) throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .MutualCouplingBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.MutualCouplingBusinessDelegate.getMutualCouplingInstance();
    UUID childId = command.getRemoveFrom().getMutualCouplingId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      MutualCouplingValidator.getInstance().validate(command);

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
   * @return MutualCoupling
   */
  private MutualCoupling load(UUID id) throws ProcessingException {
    mutualCoupling =
        MutualCouplingBusinessDelegate.getMutualCouplingInstance()
            .getMutualCoupling(new MutualCouplingFetchOneSummary(id));
    return mutualCoupling;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private MutualCoupling mutualCoupling = null;
  private static final Logger LOGGER =
      Logger.getLogger(MutualCouplingBusinessDelegate.class.getName());
}
