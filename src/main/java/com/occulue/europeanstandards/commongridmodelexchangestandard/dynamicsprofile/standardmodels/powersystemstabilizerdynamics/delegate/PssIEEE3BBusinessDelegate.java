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
 * PssIEEE3B business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PssIEEE3B related services in the case of a PssIEEE3B business
 *       related service failing.
 *   <li>Exposes a simpler, uniform PssIEEE3B interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PssIEEE3B business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PssIEEE3BBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PssIEEE3BBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PssIEEE3B Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PssIEEE3BBusinessDelegate
   */
  public static PssIEEE3BBusinessDelegate getPssIEEE3BInstance() {
    return (new PssIEEE3BBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPssIEEE3B(CreatePssIEEE3BCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPssIEEE3BId() == null) command.setPssIEEE3BId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePssIEEE3BCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePssIEEE3BCommand of PssIEEE3B is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PssIEEE3B - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePssIEEE3BCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePssIEEE3B(UpdatePssIEEE3BCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePssIEEE3BCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PssIEEE3B - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePssIEEE3BCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePssIEEE3BCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePssIEEE3BCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete PssIEEE3B using Id = " + command.getPssIEEE3BId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PssIEEE3B via PssIEEE3BFetchOneSummary
   *
   * @param summary PssIEEE3BFetchOneSummary
   * @return PssIEEE3BFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PssIEEE3B getPssIEEE3B(PssIEEE3BFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("PssIEEE3BFetchOneSummary arg cannot be null");

    PssIEEE3B entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PssIEEE3B
      // --------------------------------------
      CompletableFuture<PssIEEE3B> futureEntity =
          queryGateway.query(
              new FindPssIEEE3BQuery(new LoadPssIEEE3BFilter(summary.getPssIEEE3BId())),
              ResponseTypes.instanceOf(PssIEEE3B.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate PssIEEE3B with id " + summary.getPssIEEE3BId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PssIEEE3Bs
   *
   * @return List<PssIEEE3B>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PssIEEE3B> getAllPssIEEE3B() throws ProcessingException {
    List<PssIEEE3B> list = null;

    try {
      CompletableFuture<List<PssIEEE3B>> futureList =
          queryGateway.query(
              new FindAllPssIEEE3BQuery(), ResponseTypes.multipleInstancesOf(PssIEEE3B.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PssIEEE3B";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign A1 on PssIEEE3B
   *
   * @param command AssignA1ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignA1(AssignA1ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign A1 on PssIEEE3B
   *
   * @param command UnAssignA1FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignA1(UnAssignA1FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A1 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign A2 on PssIEEE3B
   *
   * @param command AssignA2ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignA2(AssignA2ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign A2 on PssIEEE3B
   *
   * @param command UnAssignA2FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignA2(UnAssignA2FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A2 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign A3 on PssIEEE3B
   *
   * @param command AssignA3ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignA3(AssignA3ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign A3 on PssIEEE3B
   *
   * @param command UnAssignA3FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignA3(UnAssignA3FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A3 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign A4 on PssIEEE3B
   *
   * @param command AssignA4ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignA4(AssignA4ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign A4 on PssIEEE3B
   *
   * @param command UnAssignA4FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignA4(UnAssignA4FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A4 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign A5 on PssIEEE3B
   *
   * @param command AssignA5ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignA5(AssignA5ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign A5 on PssIEEE3B
   *
   * @param command UnAssignA5FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignA5(UnAssignA5FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A5 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign A6 on PssIEEE3B
   *
   * @param command AssignA6ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignA6(AssignA6ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign A6 on PssIEEE3B
   *
   * @param command UnAssignA6FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignA6(UnAssignA6FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A6 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign A7 on PssIEEE3B
   *
   * @param command AssignA7ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignA7(AssignA7ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign A7 on PssIEEE3B
   *
   * @param command UnAssignA7FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignA7(UnAssignA7FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A7 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign A8 on PssIEEE3B
   *
   * @param command AssignA8ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignA8(AssignA8ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign A8 on PssIEEE3B
   *
   * @param command UnAssignA8FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignA8(UnAssignA8FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A8 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ks1 on PssIEEE3B
   *
   * @param command AssignKs1ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignKs1(AssignKs1ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign Ks1 on PssIEEE3B
   *
   * @param command UnAssignKs1FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignKs1(UnAssignKs1FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ks1 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ks2 on PssIEEE3B
   *
   * @param command AssignKs2ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignKs2(AssignKs2ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign Ks2 on PssIEEE3B
   *
   * @param command UnAssignKs2FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignKs2(UnAssignKs2FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ks2 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T1 on PssIEEE3B
   *
   * @param command AssignT1ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignT1(AssignT1ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign T1 on PssIEEE3B
   *
   * @param command UnAssignT1FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignT1(UnAssignT1FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T1 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T2 on PssIEEE3B
   *
   * @param command AssignT2ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignT2(AssignT2ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign T2 on PssIEEE3B
   *
   * @param command UnAssignT2FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignT2(UnAssignT2FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T2 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tw1 on PssIEEE3B
   *
   * @param command AssignTw1ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignTw1(AssignTw1ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign Tw1 on PssIEEE3B
   *
   * @param command UnAssignTw1FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignTw1(UnAssignTw1FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tw1 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tw2 on PssIEEE3B
   *
   * @param command AssignTw2ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignTw2(AssignTw2ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign Tw2 on PssIEEE3B
   *
   * @param command UnAssignTw2FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignTw2(UnAssignTw2FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tw2 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tw3 on PssIEEE3B
   *
   * @param command AssignTw3ToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignTw3(AssignTw3ToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign Tw3 on PssIEEE3B
   *
   * @param command UnAssignTw3FromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignTw3(UnAssignTw3FromPssIEEE3BCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tw3 on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vstmax on PssIEEE3B
   *
   * @param command AssignVstmaxToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignVstmax(AssignVstmaxToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign Vstmax on PssIEEE3B
   *
   * @param command UnAssignVstmaxFromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignVstmax(UnAssignVstmaxFromPssIEEE3BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vstmax on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Vstmin on PssIEEE3B
   *
   * @param command AssignVstminToPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void assignVstmin(AssignVstminToPssIEEE3BCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssIEEE3BId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssIEEE3BBusinessDelegate parentDelegate = PssIEEE3BBusinessDelegate.getPssIEEE3BInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

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
   * unAssign Vstmin on PssIEEE3B
   *
   * @param command UnAssignVstminFromPssIEEE3BCommand
   * @exception ProcessingException
   */
  public void unAssignVstmin(UnAssignVstminFromPssIEEE3BCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssIEEE3BValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Vstmin on PssIEEE3B";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PssIEEE3B
   */
  private PssIEEE3B load(UUID id) throws ProcessingException {
    pssIEEE3B =
        PssIEEE3BBusinessDelegate.getPssIEEE3BInstance()
            .getPssIEEE3B(new PssIEEE3BFetchOneSummary(id));
    return pssIEEE3B;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PssIEEE3B pssIEEE3B = null;
  private static final Logger LOGGER = Logger.getLogger(PssIEEE3BBusinessDelegate.class.getName());
}
