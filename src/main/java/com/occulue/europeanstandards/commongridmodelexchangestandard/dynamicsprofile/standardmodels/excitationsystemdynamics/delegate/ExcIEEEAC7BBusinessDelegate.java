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
 * ExcIEEEAC7B business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ExcIEEEAC7B related services in the case of a ExcIEEEAC7B
 *       business related service failing.
 *   <li>Exposes a simpler, uniform ExcIEEEAC7B interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ExcIEEEAC7B business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ExcIEEEAC7BBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ExcIEEEAC7BBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ExcIEEEAC7B Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ExcIEEEAC7BBusinessDelegate
   */
  public static ExcIEEEAC7BBusinessDelegate getExcIEEEAC7BInstance() {
    return (new ExcIEEEAC7BBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createExcIEEEAC7B(CreateExcIEEEAC7BCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getExcIEEEAC7BId() == null) command.setExcIEEEAC7BId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateExcIEEEAC7BCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateExcIEEEAC7BCommand of ExcIEEEAC7B is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ExcIEEEAC7B - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateExcIEEEAC7BCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateExcIEEEAC7B(UpdateExcIEEEAC7BCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateExcIEEEAC7BCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ExcIEEEAC7B - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteExcIEEEAC7BCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteExcIEEEAC7BCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteExcIEEEAC7BCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete ExcIEEEAC7B using Id = " + command.getExcIEEEAC7BId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ExcIEEEAC7B via ExcIEEEAC7BFetchOneSummary
   *
   * @param summary ExcIEEEAC7BFetchOneSummary
   * @return ExcIEEEAC7BFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ExcIEEEAC7B getExcIEEEAC7B(ExcIEEEAC7BFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ExcIEEEAC7BFetchOneSummary arg cannot be null");

    ExcIEEEAC7B entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ExcIEEEAC7B
      // --------------------------------------
      CompletableFuture<ExcIEEEAC7B> futureEntity =
          queryGateway.query(
              new FindExcIEEEAC7BQuery(new LoadExcIEEEAC7BFilter(summary.getExcIEEEAC7BId())),
              ResponseTypes.instanceOf(ExcIEEEAC7B.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate ExcIEEEAC7B with id " + summary.getExcIEEEAC7BId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC7Bs
   *
   * @return List<ExcIEEEAC7B>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ExcIEEEAC7B> getAllExcIEEEAC7B() throws ProcessingException {
    List<ExcIEEEAC7B> list = null;

    try {
      CompletableFuture<List<ExcIEEEAC7B>> futureList =
          queryGateway.query(
              new FindAllExcIEEEAC7BQuery(), ResponseTypes.multipleInstancesOf(ExcIEEEAC7B.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Kc on ExcIEEEAC7B
   *
   * @param command AssignKcToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKc(AssignKcToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Kc on ExcIEEEAC7B
   *
   * @param command UnAssignKcFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKc(UnAssignKcFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kc on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kd on ExcIEEEAC7B
   *
   * @param command AssignKdToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKd(AssignKdToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Kd on ExcIEEEAC7B
   *
   * @param command UnAssignKdFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKd(UnAssignKdFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kd on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kdr on ExcIEEEAC7B
   *
   * @param command AssignKdrToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKdr(AssignKdrToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Kdr on ExcIEEEAC7B
   *
   * @param command UnAssignKdrFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKdr(UnAssignKdrFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kdr on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ke on ExcIEEEAC7B
   *
   * @param command AssignKeToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKe(AssignKeToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Ke on ExcIEEEAC7B
   *
   * @param command UnAssignKeFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKe(UnAssignKeFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ke on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kf1 on ExcIEEEAC7B
   *
   * @param command AssignKf1ToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKf1(AssignKf1ToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Kf1 on ExcIEEEAC7B
   *
   * @param command UnAssignKf1FromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKf1(UnAssignKf1FromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kf1 on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kf2 on ExcIEEEAC7B
   *
   * @param command AssignKf2ToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKf2(AssignKf2ToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Kf2 on ExcIEEEAC7B
   *
   * @param command UnAssignKf2FromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKf2(UnAssignKf2FromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kf2 on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kf3 on ExcIEEEAC7B
   *
   * @param command AssignKf3ToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKf3(AssignKf3ToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Kf3 on ExcIEEEAC7B
   *
   * @param command UnAssignKf3FromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKf3(UnAssignKf3FromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kf3 on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kia on ExcIEEEAC7B
   *
   * @param command AssignKiaToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKia(AssignKiaToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Kia on ExcIEEEAC7B
   *
   * @param command UnAssignKiaFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKia(UnAssignKiaFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kia on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kir on ExcIEEEAC7B
   *
   * @param command AssignKirToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKir(AssignKirToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Kir on ExcIEEEAC7B
   *
   * @param command UnAssignKirFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKir(UnAssignKirFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kir on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kl on ExcIEEEAC7B
   *
   * @param command AssignKlToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKl(AssignKlToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Kl on ExcIEEEAC7B
   *
   * @param command UnAssignKlFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKl(UnAssignKlFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kl on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kp on ExcIEEEAC7B
   *
   * @param command AssignKpToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKp(AssignKpToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Kp on ExcIEEEAC7B
   *
   * @param command UnAssignKpFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKp(UnAssignKpFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kp on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpa on ExcIEEEAC7B
   *
   * @param command AssignKpaToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKpa(AssignKpaToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Kpa on ExcIEEEAC7B
   *
   * @param command UnAssignKpaFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKpa(UnAssignKpaFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpa on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpr on ExcIEEEAC7B
   *
   * @param command AssignKprToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignKpr(AssignKprToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Kpr on ExcIEEEAC7B
   *
   * @param command UnAssignKprFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignKpr(UnAssignKprFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpr on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Seve1 on ExcIEEEAC7B
   *
   * @param command AssignSeve1ToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignSeve1(AssignSeve1ToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Seve1 on ExcIEEEAC7B
   *
   * @param command UnAssignSeve1FromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignSeve1(UnAssignSeve1FromExcIEEEAC7BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Seve1 on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Seve2 on ExcIEEEAC7B
   *
   * @param command AssignSeve2ToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignSeve2(AssignSeve2ToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Seve2 on ExcIEEEAC7B
   *
   * @param command UnAssignSeve2FromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignSeve2(UnAssignSeve2FromExcIEEEAC7BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Seve2 on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tdr on ExcIEEEAC7B
   *
   * @param command AssignTdrToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignTdr(AssignTdrToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Tdr on ExcIEEEAC7B
   *
   * @param command UnAssignTdrFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignTdr(UnAssignTdrFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tdr on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Te on ExcIEEEAC7B
   *
   * @param command AssignTeToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignTe(AssignTeToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Te on ExcIEEEAC7B
   *
   * @param command UnAssignTeFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignTe(UnAssignTeFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Te on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tf on ExcIEEEAC7B
   *
   * @param command AssignTfToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignTf(AssignTfToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Tf on ExcIEEEAC7B
   *
   * @param command UnAssignTfFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignTf(UnAssignTfFromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tf on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vamax on ExcIEEEAC7B
   *
   * @param command AssignVamaxToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignVamax(AssignVamaxToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Vamax on ExcIEEEAC7B
   *
   * @param command UnAssignVamaxFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignVamax(UnAssignVamaxFromExcIEEEAC7BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vamax on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vamin on ExcIEEEAC7B
   *
   * @param command AssignVaminToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignVamin(AssignVaminToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Vamin on ExcIEEEAC7B
   *
   * @param command UnAssignVaminFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignVamin(UnAssignVaminFromExcIEEEAC7BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vamin on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ve1 on ExcIEEEAC7B
   *
   * @param command AssignVe1ToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignVe1(AssignVe1ToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Ve1 on ExcIEEEAC7B
   *
   * @param command UnAssignVe1FromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignVe1(UnAssignVe1FromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ve1 on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ve2 on ExcIEEEAC7B
   *
   * @param command AssignVe2ToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignVe2(AssignVe2ToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Ve2 on ExcIEEEAC7B
   *
   * @param command UnAssignVe2FromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignVe2(UnAssignVe2FromExcIEEEAC7BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ve2 on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vemin on ExcIEEEAC7B
   *
   * @param command AssignVeminToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignVemin(AssignVeminToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Vemin on ExcIEEEAC7B
   *
   * @param command UnAssignVeminFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignVemin(UnAssignVeminFromExcIEEEAC7BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vemin on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vfemax on ExcIEEEAC7B
   *
   * @param command AssignVfemaxToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignVfemax(AssignVfemaxToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Vfemax on ExcIEEEAC7B
   *
   * @param command UnAssignVfemaxFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignVfemax(UnAssignVfemaxFromExcIEEEAC7BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vfemax on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vrmax on ExcIEEEAC7B
   *
   * @param command AssignVrmaxToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignVrmax(AssignVrmaxToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Vrmax on ExcIEEEAC7B
   *
   * @param command UnAssignVrmaxFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignVrmax(UnAssignVrmaxFromExcIEEEAC7BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vrmax on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vrmin on ExcIEEEAC7B
   *
   * @param command AssignVrminToExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void assignVrmin(AssignVrminToExcIEEEAC7BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEAC7BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEAC7BBusinessDelegate parentDelegate =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

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
   * unAssign Vrmin on ExcIEEEAC7B
   *
   * @param command UnAssignVrminFromExcIEEEAC7BCommand
   * @exception ProcessingException
   */
  public void unAssignVrmin(UnAssignVrminFromExcIEEEAC7BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEAC7BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vrmin on ExcIEEEAC7B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ExcIEEEAC7B
   */
  private ExcIEEEAC7B load(UUID id) throws ProcessingException {
    excIEEEAC7B =
        ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance()
            .getExcIEEEAC7B(new ExcIEEEAC7BFetchOneSummary(id));
    return excIEEEAC7B;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ExcIEEEAC7B excIEEEAC7B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEAC7BBusinessDelegate.class.getName());
}
