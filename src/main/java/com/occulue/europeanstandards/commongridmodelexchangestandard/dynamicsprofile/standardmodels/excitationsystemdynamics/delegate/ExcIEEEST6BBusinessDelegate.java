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
 * ExcIEEEST6B business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ExcIEEEST6B related services in the case of a ExcIEEEST6B
 *       business related service failing.
 *   <li>Exposes a simpler, uniform ExcIEEEST6B interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ExcIEEEST6B business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ExcIEEEST6BBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ExcIEEEST6BBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ExcIEEEST6B Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ExcIEEEST6BBusinessDelegate
   */
  public static ExcIEEEST6BBusinessDelegate getExcIEEEST6BInstance() {
    return (new ExcIEEEST6BBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createExcIEEEST6B(CreateExcIEEEST6BCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getExcIEEEST6BId() == null) command.setExcIEEEST6BId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateExcIEEEST6BCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateExcIEEEST6BCommand of ExcIEEEST6B is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ExcIEEEST6B - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateExcIEEEST6BCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateExcIEEEST6B(UpdateExcIEEEST6BCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateExcIEEEST6BCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ExcIEEEST6B - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteExcIEEEST6BCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteExcIEEEST6BCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteExcIEEEST6BCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete ExcIEEEST6B using Id = " + command.getExcIEEEST6BId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ExcIEEEST6B via ExcIEEEST6BFetchOneSummary
   *
   * @param summary ExcIEEEST6BFetchOneSummary
   * @return ExcIEEEST6BFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ExcIEEEST6B getExcIEEEST6B(ExcIEEEST6BFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ExcIEEEST6BFetchOneSummary arg cannot be null");

    ExcIEEEST6B entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ExcIEEEST6B
      // --------------------------------------
      CompletableFuture<ExcIEEEST6B> futureEntity =
          queryGateway.query(
              new FindExcIEEEST6BQuery(new LoadExcIEEEST6BFilter(summary.getExcIEEEST6BId())),
              ResponseTypes.instanceOf(ExcIEEEST6B.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate ExcIEEEST6B with id " + summary.getExcIEEEST6BId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST6Bs
   *
   * @return List<ExcIEEEST6B>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ExcIEEEST6B> getAllExcIEEEST6B() throws ProcessingException {
    List<ExcIEEEST6B> list = null;

    try {
      CompletableFuture<List<ExcIEEEST6B>> futureList =
          queryGateway.query(
              new FindAllExcIEEEST6BQuery(), ResponseTypes.multipleInstancesOf(ExcIEEEST6B.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ExcIEEEST6B";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Ilr on ExcIEEEST6B
   *
   * @param command AssignIlrToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignIlr(AssignIlrToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Ilr on ExcIEEEST6B
   *
   * @param command UnAssignIlrFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignIlr(UnAssignIlrFromExcIEEEST6BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ilr on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kci on ExcIEEEST6B
   *
   * @param command AssignKciToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignKci(AssignKciToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Kci on ExcIEEEST6B
   *
   * @param command UnAssignKciFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignKci(UnAssignKciFromExcIEEEST6BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kci on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kff on ExcIEEEST6B
   *
   * @param command AssignKffToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignKff(AssignKffToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Kff on ExcIEEEST6B
   *
   * @param command UnAssignKffFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignKff(UnAssignKffFromExcIEEEST6BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kff on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kg on ExcIEEEST6B
   *
   * @param command AssignKgToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignKg(AssignKgToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Kg on ExcIEEEST6B
   *
   * @param command UnAssignKgFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignKg(UnAssignKgFromExcIEEEST6BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kg on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kia on ExcIEEEST6B
   *
   * @param command AssignKiaToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignKia(AssignKiaToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Kia on ExcIEEEST6B
   *
   * @param command UnAssignKiaFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignKia(UnAssignKiaFromExcIEEEST6BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kia on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Klr on ExcIEEEST6B
   *
   * @param command AssignKlrToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignKlr(AssignKlrToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Klr on ExcIEEEST6B
   *
   * @param command UnAssignKlrFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignKlr(UnAssignKlrFromExcIEEEST6BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Klr on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Km on ExcIEEEST6B
   *
   * @param command AssignKmToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignKm(AssignKmToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Km on ExcIEEEST6B
   *
   * @param command UnAssignKmFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignKm(UnAssignKmFromExcIEEEST6BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Km on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpa on ExcIEEEST6B
   *
   * @param command AssignKpaToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignKpa(AssignKpaToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Kpa on ExcIEEEST6B
   *
   * @param command UnAssignKpaFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignKpa(UnAssignKpaFromExcIEEEST6BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpa on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tg on ExcIEEEST6B
   *
   * @param command AssignTgToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignTg(AssignTgToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Tg on ExcIEEEST6B
   *
   * @param command UnAssignTgFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignTg(UnAssignTgFromExcIEEEST6BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tg on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vamax on ExcIEEEST6B
   *
   * @param command AssignVamaxToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignVamax(AssignVamaxToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Vamax on ExcIEEEST6B
   *
   * @param command UnAssignVamaxFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignVamax(UnAssignVamaxFromExcIEEEST6BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vamax on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vamin on ExcIEEEST6B
   *
   * @param command AssignVaminToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignVamin(AssignVaminToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Vamin on ExcIEEEST6B
   *
   * @param command UnAssignVaminFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignVamin(UnAssignVaminFromExcIEEEST6BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vamin on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vrmax on ExcIEEEST6B
   *
   * @param command AssignVrmaxToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignVrmax(AssignVrmaxToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Vrmax on ExcIEEEST6B
   *
   * @param command UnAssignVrmaxFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignVrmax(UnAssignVrmaxFromExcIEEEST6BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vrmax on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vrmin on ExcIEEEST6B
   *
   * @param command AssignVrminToExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void assignVrmin(AssignVrminToExcIEEEST6BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcIEEEST6BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    ExcIEEEST6BBusinessDelegate parentDelegate =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

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
   * unAssign Vrmin on ExcIEEEST6B
   *
   * @param command UnAssignVrminFromExcIEEEST6BCommand
   * @exception ProcessingException
   */
  public void unAssignVrmin(UnAssignVrminFromExcIEEEST6BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcIEEEST6BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vrmin on ExcIEEEST6B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ExcIEEEST6B
   */
  private ExcIEEEST6B load(UUID id) throws ProcessingException {
    excIEEEST6B =
        ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance()
            .getExcIEEEST6B(new ExcIEEEST6BFetchOneSummary(id));
    return excIEEEST6B;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ExcIEEEST6B excIEEEST6B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEST6BBusinessDelegate.class.getName());
}
