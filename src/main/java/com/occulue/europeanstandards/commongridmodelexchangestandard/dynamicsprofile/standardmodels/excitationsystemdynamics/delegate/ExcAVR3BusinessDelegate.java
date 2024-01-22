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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.validator.*;
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
 * ExcAVR3 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ExcAVR3 related services in the case of a ExcAVR3 business
 *       related service failing.
 *   <li>Exposes a simpler, uniform ExcAVR3 interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ExcAVR3 business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ExcAVR3BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ExcAVR3BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ExcAVR3 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ExcAVR3BusinessDelegate
   */
  public static ExcAVR3BusinessDelegate getExcAVR3Instance() {
    return (new ExcAVR3BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createExcAVR3(CreateExcAVR3Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getExcAVR3Id() == null) command.setExcAVR3Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateExcAVR3Command - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateExcAVR3Command of ExcAVR3 is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ExcAVR3 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateExcAVR3Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateExcAVR3(UpdateExcAVR3Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateExcAVR3Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ExcAVR3 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteExcAVR3Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteExcAVR3Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteExcAVR3Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete ExcAVR3 using Id = " + command.getExcAVR3Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ExcAVR3 via ExcAVR3FetchOneSummary
   *
   * @param summary ExcAVR3FetchOneSummary
   * @return ExcAVR3FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ExcAVR3 getExcAVR3(ExcAVR3FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ExcAVR3FetchOneSummary arg cannot be null");

    ExcAVR3 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ExcAVR3
      // --------------------------------------
      CompletableFuture<ExcAVR3> futureEntity =
          queryGateway.query(
              new FindExcAVR3Query(new LoadExcAVR3Filter(summary.getExcAVR3Id())),
              ResponseTypes.instanceOf(ExcAVR3.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate ExcAVR3 with id " + summary.getExcAVR3Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ExcAVR3s
   *
   * @return List<ExcAVR3>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ExcAVR3> getAllExcAVR3() throws ProcessingException {
    List<ExcAVR3> list = null;

    try {
      CompletableFuture<List<ExcAVR3>> futureList =
          queryGateway.query(
              new FindAllExcAVR3Query(), ResponseTypes.multipleInstancesOf(ExcAVR3.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ExcAVR3";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign E1 on ExcAVR3
   *
   * @param command AssignE1ToExcAVR3Command
   * @exception ProcessingException
   */
  public void assignE1(AssignE1ToExcAVR3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAVR3BusinessDelegate parentDelegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

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
   * unAssign E1 on ExcAVR3
   *
   * @param command UnAssignE1FromExcAVR3Command
   * @exception ProcessingException
   */
  public void unAssignE1(UnAssignE1FromExcAVR3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign E1 on ExcAVR3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign E2 on ExcAVR3
   *
   * @param command AssignE2ToExcAVR3Command
   * @exception ProcessingException
   */
  public void assignE2(AssignE2ToExcAVR3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAVR3BusinessDelegate parentDelegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

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
   * unAssign E2 on ExcAVR3
   *
   * @param command UnAssignE2FromExcAVR3Command
   * @exception ProcessingException
   */
  public void unAssignE2(UnAssignE2FromExcAVR3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign E2 on ExcAVR3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ka on ExcAVR3
   *
   * @param command AssignKaToExcAVR3Command
   * @exception ProcessingException
   */
  public void assignKa(AssignKaToExcAVR3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExcAVR3BusinessDelegate parentDelegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

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
   * unAssign Ka on ExcAVR3
   *
   * @param command UnAssignKaFromExcAVR3Command
   * @exception ProcessingException
   */
  public void unAssignKa(UnAssignKaFromExcAVR3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ka on ExcAVR3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Se1 on ExcAVR3
   *
   * @param command AssignSe1ToExcAVR3Command
   * @exception ProcessingException
   */
  public void assignSe1(AssignSe1ToExcAVR3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExcAVR3BusinessDelegate parentDelegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

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
   * unAssign Se1 on ExcAVR3
   *
   * @param command UnAssignSe1FromExcAVR3Command
   * @exception ProcessingException
   */
  public void unAssignSe1(UnAssignSe1FromExcAVR3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Se1 on ExcAVR3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Se2 on ExcAVR3
   *
   * @param command AssignSe2ToExcAVR3Command
   * @exception ProcessingException
   */
  public void assignSe2(AssignSe2ToExcAVR3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExcAVR3BusinessDelegate parentDelegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

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
   * unAssign Se2 on ExcAVR3
   *
   * @param command UnAssignSe2FromExcAVR3Command
   * @exception ProcessingException
   */
  public void unAssignSe2(UnAssignSe2FromExcAVR3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Se2 on ExcAVR3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T1 on ExcAVR3
   *
   * @param command AssignT1ToExcAVR3Command
   * @exception ProcessingException
   */
  public void assignT1(AssignT1ToExcAVR3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcAVR3BusinessDelegate parentDelegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

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
   * unAssign T1 on ExcAVR3
   *
   * @param command UnAssignT1FromExcAVR3Command
   * @exception ProcessingException
   */
  public void unAssignT1(UnAssignT1FromExcAVR3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T1 on ExcAVR3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T2 on ExcAVR3
   *
   * @param command AssignT2ToExcAVR3Command
   * @exception ProcessingException
   */
  public void assignT2(AssignT2ToExcAVR3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcAVR3BusinessDelegate parentDelegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

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
   * unAssign T2 on ExcAVR3
   *
   * @param command UnAssignT2FromExcAVR3Command
   * @exception ProcessingException
   */
  public void unAssignT2(UnAssignT2FromExcAVR3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T2 on ExcAVR3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T3 on ExcAVR3
   *
   * @param command AssignT3ToExcAVR3Command
   * @exception ProcessingException
   */
  public void assignT3(AssignT3ToExcAVR3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcAVR3BusinessDelegate parentDelegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

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
   * unAssign T3 on ExcAVR3
   *
   * @param command UnAssignT3FromExcAVR3Command
   * @exception ProcessingException
   */
  public void unAssignT3(UnAssignT3FromExcAVR3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T3 on ExcAVR3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T4 on ExcAVR3
   *
   * @param command AssignT4ToExcAVR3Command
   * @exception ProcessingException
   */
  public void assignT4(AssignT4ToExcAVR3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcAVR3BusinessDelegate parentDelegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

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
   * unAssign T4 on ExcAVR3
   *
   * @param command UnAssignT4FromExcAVR3Command
   * @exception ProcessingException
   */
  public void unAssignT4(UnAssignT4FromExcAVR3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T4 on ExcAVR3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Te on ExcAVR3
   *
   * @param command AssignTeToExcAVR3Command
   * @exception ProcessingException
   */
  public void assignTe(AssignTeToExcAVR3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcAVR3BusinessDelegate parentDelegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

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
   * unAssign Te on ExcAVR3
   *
   * @param command UnAssignTeFromExcAVR3Command
   * @exception ProcessingException
   */
  public void unAssignTe(UnAssignTeFromExcAVR3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Te on ExcAVR3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vrmn on ExcAVR3
   *
   * @param command AssignVrmnToExcAVR3Command
   * @exception ProcessingException
   */
  public void assignVrmn(AssignVrmnToExcAVR3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAVR3BusinessDelegate parentDelegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

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
   * unAssign Vrmn on ExcAVR3
   *
   * @param command UnAssignVrmnFromExcAVR3Command
   * @exception ProcessingException
   */
  public void unAssignVrmn(UnAssignVrmnFromExcAVR3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vrmn on ExcAVR3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vrmx on ExcAVR3
   *
   * @param command AssignVrmxToExcAVR3Command
   * @exception ProcessingException
   */
  public void assignVrmx(AssignVrmxToExcAVR3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcAVR3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcAVR3BusinessDelegate parentDelegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

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
   * unAssign Vrmx on ExcAVR3
   *
   * @param command UnAssignVrmxFromExcAVR3Command
   * @exception ProcessingException
   */
  public void unAssignVrmx(UnAssignVrmxFromExcAVR3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcAVR3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vrmx on ExcAVR3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ExcAVR3
   */
  private ExcAVR3 load(UUID id) throws ProcessingException {
    excAVR3 =
        ExcAVR3BusinessDelegate.getExcAVR3Instance().getExcAVR3(new ExcAVR3FetchOneSummary(id));
    return excAVR3;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ExcAVR3 excAVR3 = null;
  private static final Logger LOGGER = Logger.getLogger(ExcAVR3BusinessDelegate.class.getName());
}
