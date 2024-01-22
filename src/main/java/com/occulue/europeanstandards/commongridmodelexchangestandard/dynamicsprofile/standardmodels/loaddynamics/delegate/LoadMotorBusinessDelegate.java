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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.validator.*;
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
 * LoadMotor business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of LoadMotor related services in the case of a LoadMotor business
 *       related service failing.
 *   <li>Exposes a simpler, uniform LoadMotor interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill LoadMotor business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class LoadMotorBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public LoadMotorBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * LoadMotor Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return LoadMotorBusinessDelegate
   */
  public static LoadMotorBusinessDelegate getLoadMotorInstance() {
    return (new LoadMotorBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createLoadMotor(CreateLoadMotorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getLoadMotorId() == null) command.setLoadMotorId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateLoadMotorCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateLoadMotorCommand of LoadMotor is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create LoadMotor - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateLoadMotorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateLoadMotor(UpdateLoadMotorCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateLoadMotorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save LoadMotor - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteLoadMotorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteLoadMotorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteLoadMotorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete LoadMotor using Id = " + command.getLoadMotorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the LoadMotor via LoadMotorFetchOneSummary
   *
   * @param summary LoadMotorFetchOneSummary
   * @return LoadMotorFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public LoadMotor getLoadMotor(LoadMotorFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("LoadMotorFetchOneSummary arg cannot be null");

    LoadMotor entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a LoadMotor
      // --------------------------------------
      CompletableFuture<LoadMotor> futureEntity =
          queryGateway.query(
              new FindLoadMotorQuery(new LoadLoadMotorFilter(summary.getLoadMotorId())),
              ResponseTypes.instanceOf(LoadMotor.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate LoadMotor with id " + summary.getLoadMotorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all LoadMotors
   *
   * @return List<LoadMotor>
   * @exception ProcessingException Thrown if any problems
   */
  public List<LoadMotor> getAllLoadMotor() throws ProcessingException {
    List<LoadMotor> list = null;

    try {
      CompletableFuture<List<LoadMotor>> futureList =
          queryGateway.query(
              new FindAllLoadMotorQuery(), ResponseTypes.multipleInstancesOf(LoadMotor.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all LoadMotor";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign D on LoadMotor
   *
   * @param command AssignDToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignD(AssignDToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign D on LoadMotor
   *
   * @param command UnAssignDFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignD(UnAssignDFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign D on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign H on LoadMotor
   *
   * @param command AssignHToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignH(AssignHToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign H on LoadMotor
   *
   * @param command UnAssignHFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignH(UnAssignHFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign H on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Lfac on LoadMotor
   *
   * @param command AssignLfacToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignLfac(AssignLfacToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Lfac on LoadMotor
   *
   * @param command UnAssignLfacFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignLfac(UnAssignLfacFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Lfac on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Lp on LoadMotor
   *
   * @param command AssignLpToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignLp(AssignLpToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Lp on LoadMotor
   *
   * @param command UnAssignLpFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignLp(UnAssignLpFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Lp on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Lpp on LoadMotor
   *
   * @param command AssignLppToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignLpp(AssignLppToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Lpp on LoadMotor
   *
   * @param command UnAssignLppFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignLpp(UnAssignLppFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Lpp on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ls on LoadMotor
   *
   * @param command AssignLsToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignLs(AssignLsToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Ls on LoadMotor
   *
   * @param command UnAssignLsFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignLs(UnAssignLsFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ls on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pfrac on LoadMotor
   *
   * @param command AssignPfracToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignPfrac(AssignPfracToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Pfrac on LoadMotor
   *
   * @param command UnAssignPfracFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignPfrac(UnAssignPfracFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pfrac on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ra on LoadMotor
   *
   * @param command AssignRaToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignRa(AssignRaToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Ra on LoadMotor
   *
   * @param command UnAssignRaFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignRa(UnAssignRaFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ra on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tbkr on LoadMotor
   *
   * @param command AssignTbkrToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignTbkr(AssignTbkrToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Tbkr on LoadMotor
   *
   * @param command UnAssignTbkrFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignTbkr(UnAssignTbkrFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tbkr on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpo on LoadMotor
   *
   * @param command AssignTpoToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignTpo(AssignTpoToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Tpo on LoadMotor
   *
   * @param command UnAssignTpoFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignTpo(UnAssignTpoFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpo on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tppo on LoadMotor
   *
   * @param command AssignTppoToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignTppo(AssignTppoToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Tppo on LoadMotor
   *
   * @param command UnAssignTppoFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignTppo(UnAssignTppoFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tppo on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tv on LoadMotor
   *
   * @param command AssignTvToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignTv(AssignTvToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Tv on LoadMotor
   *
   * @param command UnAssignTvFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignTv(UnAssignTvFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tv on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vt on LoadMotor
   *
   * @param command AssignVtToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignVt(AssignVtToLoadMotorCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Vt on LoadMotor
   *
   * @param command UnAssignVtFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignVt(UnAssignVtFromLoadMotorCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vt on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign LoadMotor on LoadMotor
   *
   * @param command AssignLoadMotorToLoadMotorCommand
   * @exception ProcessingException
   */
  public void assignLoadMotor(AssignLoadMotorToLoadMotorCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getLoadMotorId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
            .loaddynamics.delegate.LoadMotorBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
                .standardmodels.loaddynamics.delegate.LoadMotorBusinessDelegate
                .getLoadMotorInstance();
    LoadMotorBusinessDelegate parentDelegate = LoadMotorBusinessDelegate.getLoadMotorInstance();
    UUID childId = command.getAssignment().getLoadMotorId();
    LoadMotor child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get LoadMotor using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign LoadMotor on LoadMotor
   *
   * @param command UnAssignLoadMotorFromLoadMotorCommand
   * @exception ProcessingException
   */
  public void unAssignLoadMotor(UnAssignLoadMotorFromLoadMotorCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      LoadMotorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign LoadMotor on LoadMotor";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return LoadMotor
   */
  private LoadMotor load(UUID id) throws ProcessingException {
    loadMotor =
        LoadMotorBusinessDelegate.getLoadMotorInstance()
            .getLoadMotor(new LoadMotorFetchOneSummary(id));
    return loadMotor;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private LoadMotor loadMotor = null;
  private static final Logger LOGGER = Logger.getLogger(LoadMotorBusinessDelegate.class.getName());
}
