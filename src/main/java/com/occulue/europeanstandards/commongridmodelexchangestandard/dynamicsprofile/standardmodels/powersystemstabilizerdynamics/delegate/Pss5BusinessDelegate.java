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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.validator.*;
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
 * Pss5 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Pss5 related services in the case of a Pss5 business related
 *       service failing.
 *   <li>Exposes a simpler, uniform Pss5 interface to the business tier, making it easy for clients
 *       to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Pss5 business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class Pss5BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public Pss5BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Pss5 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return Pss5BusinessDelegate
   */
  public static Pss5BusinessDelegate getPss5Instance() {
    return (new Pss5BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPss5(CreatePss5Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPss5Id() == null) command.setPss5Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePss5Command - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO, "return from Command Gateway for CreatePss5Command of Pss5 is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Pss5 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePss5Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePss5(UpdatePss5Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePss5Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Pss5 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePss5Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePss5Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePss5Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Pss5 using Id = " + command.getPss5Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Pss5 via Pss5FetchOneSummary
   *
   * @param summary Pss5FetchOneSummary
   * @return Pss5FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Pss5 getPss5(Pss5FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("Pss5FetchOneSummary arg cannot be null");

    Pss5 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      Pss5Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Pss5
      // --------------------------------------
      CompletableFuture<Pss5> futureEntity =
          queryGateway.query(
              new FindPss5Query(new LoadPss5Filter(summary.getPss5Id())),
              ResponseTypes.instanceOf(Pss5.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Pss5 with id " + summary.getPss5Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Pss5s
   *
   * @return List<Pss5>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Pss5> getAllPss5() throws ProcessingException {
    List<Pss5> list = null;

    try {
      CompletableFuture<List<Pss5>> futureList =
          queryGateway.query(new FindAllPss5Query(), ResponseTypes.multipleInstancesOf(Pss5.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Pss5";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Ctw2 on Pss5
   *
   * @param command AssignCtw2ToPss5Command
   * @exception ProcessingException
   */
  public void assignCtw2(AssignCtw2ToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Ctw2 on Pss5
   *
   * @param command UnAssignCtw2FromPss5Command
   * @exception ProcessingException
   */
  public void unAssignCtw2(UnAssignCtw2FromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ctw2 on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Deadband on Pss5
   *
   * @param command AssignDeadbandToPss5Command
   * @exception ProcessingException
   */
  public void assignDeadband(AssignDeadbandToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Deadband on Pss5
   *
   * @param command UnAssignDeadbandFromPss5Command
   * @exception ProcessingException
   */
  public void unAssignDeadband(UnAssignDeadbandFromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Deadband on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Isfreq on Pss5
   *
   * @param command AssignIsfreqToPss5Command
   * @exception ProcessingException
   */
  public void assignIsfreq(AssignIsfreqToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Isfreq on Pss5
   *
   * @param command UnAssignIsfreqFromPss5Command
   * @exception ProcessingException
   */
  public void unAssignIsfreq(UnAssignIsfreqFromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Isfreq on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kf on Pss5
   *
   * @param command AssignKfToPss5Command
   * @exception ProcessingException
   */
  public void assignKf(AssignKfToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Kf on Pss5
   *
   * @param command UnAssignKfFromPss5Command
   * @exception ProcessingException
   */
  public void unAssignKf(UnAssignKfFromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kf on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpe on Pss5
   *
   * @param command AssignKpeToPss5Command
   * @exception ProcessingException
   */
  public void assignKpe(AssignKpeToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Kpe on Pss5
   *
   * @param command UnAssignKpeFromPss5Command
   * @exception ProcessingException
   */
  public void unAssignKpe(UnAssignKpeFromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpe on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpss on Pss5
   *
   * @param command AssignKpssToPss5Command
   * @exception ProcessingException
   */
  public void assignKpss(AssignKpssToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Kpss on Pss5
   *
   * @param command UnAssignKpssFromPss5Command
   * @exception ProcessingException
   */
  public void unAssignKpss(UnAssignKpssFromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpss on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pmm on Pss5
   *
   * @param command AssignPmmToPss5Command
   * @exception ProcessingException
   */
  public void assignPmm(AssignPmmToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Pmm on Pss5
   *
   * @param command UnAssignPmmFromPss5Command
   * @exception ProcessingException
   */
  public void unAssignPmm(UnAssignPmmFromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pmm on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tl1 on Pss5
   *
   * @param command AssignTl1ToPss5Command
   * @exception ProcessingException
   */
  public void assignTl1(AssignTl1ToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Tl1 on Pss5
   *
   * @param command UnAssignTl1FromPss5Command
   * @exception ProcessingException
   */
  public void unAssignTl1(UnAssignTl1FromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tl1 on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tl2 on Pss5
   *
   * @param command AssignTl2ToPss5Command
   * @exception ProcessingException
   */
  public void assignTl2(AssignTl2ToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Tl2 on Pss5
   *
   * @param command UnAssignTl2FromPss5Command
   * @exception ProcessingException
   */
  public void unAssignTl2(UnAssignTl2FromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tl2 on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tl3 on Pss5
   *
   * @param command AssignTl3ToPss5Command
   * @exception ProcessingException
   */
  public void assignTl3(AssignTl3ToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Tl3 on Pss5
   *
   * @param command UnAssignTl3FromPss5Command
   * @exception ProcessingException
   */
  public void unAssignTl3(UnAssignTl3FromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tl3 on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tl4 on Pss5
   *
   * @param command AssignTl4ToPss5Command
   * @exception ProcessingException
   */
  public void assignTl4(AssignTl4ToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Tl4 on Pss5
   *
   * @param command UnAssignTl4FromPss5Command
   * @exception ProcessingException
   */
  public void unAssignTl4(UnAssignTl4FromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tl4 on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpe on Pss5
   *
   * @param command AssignTpeToPss5Command
   * @exception ProcessingException
   */
  public void assignTpe(AssignTpeToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Tpe on Pss5
   *
   * @param command UnAssignTpeFromPss5Command
   * @exception ProcessingException
   */
  public void unAssignTpe(UnAssignTpeFromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpe on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tw1 on Pss5
   *
   * @param command AssignTw1ToPss5Command
   * @exception ProcessingException
   */
  public void assignTw1(AssignTw1ToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Tw1 on Pss5
   *
   * @param command UnAssignTw1FromPss5Command
   * @exception ProcessingException
   */
  public void unAssignTw1(UnAssignTw1FromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tw1 on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tw2 on Pss5
   *
   * @param command AssignTw2ToPss5Command
   * @exception ProcessingException
   */
  public void assignTw2(AssignTw2ToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Tw2 on Pss5
   *
   * @param command UnAssignTw2FromPss5Command
   * @exception ProcessingException
   */
  public void unAssignTw2(UnAssignTw2FromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tw2 on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vadat on Pss5
   *
   * @param command AssignVadatToPss5Command
   * @exception ProcessingException
   */
  public void assignVadat(AssignVadatToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Vadat on Pss5
   *
   * @param command UnAssignVadatFromPss5Command
   * @exception ProcessingException
   */
  public void unAssignVadat(UnAssignVadatFromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vadat on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vsmn on Pss5
   *
   * @param command AssignVsmnToPss5Command
   * @exception ProcessingException
   */
  public void assignVsmn(AssignVsmnToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Vsmn on Pss5
   *
   * @param command UnAssignVsmnFromPss5Command
   * @exception ProcessingException
   */
  public void unAssignVsmn(UnAssignVsmnFromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vsmn on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vsmx on Pss5
   *
   * @param command AssignVsmxToPss5Command
   * @exception ProcessingException
   */
  public void assignVsmx(AssignVsmxToPss5Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPss5Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    Pss5BusinessDelegate parentDelegate = Pss5BusinessDelegate.getPss5Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

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
   * unAssign Vsmx on Pss5
   *
   * @param command UnAssignVsmxFromPss5Command
   * @exception ProcessingException
   */
  public void unAssignVsmx(UnAssignVsmxFromPss5Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      Pss5Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vsmx on Pss5";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Pss5
   */
  private Pss5 load(UUID id) throws ProcessingException {
    pss5 = Pss5BusinessDelegate.getPss5Instance().getPss5(new Pss5FetchOneSummary(id));
    return pss5;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Pss5 pss5 = null;
  private static final Logger LOGGER = Logger.getLogger(Pss5BusinessDelegate.class.getName());
}
