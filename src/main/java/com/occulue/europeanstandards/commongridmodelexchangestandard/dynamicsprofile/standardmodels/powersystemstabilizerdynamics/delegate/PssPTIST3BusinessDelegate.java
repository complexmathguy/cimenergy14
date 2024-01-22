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
 * PssPTIST3 business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PssPTIST3 related services in the case of a PssPTIST3 business
 *       related service failing.
 *   <li>Exposes a simpler, uniform PssPTIST3 interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PssPTIST3 business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PssPTIST3BusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PssPTIST3BusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PssPTIST3 Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PssPTIST3BusinessDelegate
   */
  public static PssPTIST3BusinessDelegate getPssPTIST3Instance() {
    return (new PssPTIST3BusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPssPTIST3(CreatePssPTIST3Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPssPTIST3Id() == null) command.setPssPTIST3Id(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePssPTIST3Command - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePssPTIST3Command of PssPTIST3 is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PssPTIST3 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePssPTIST3Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePssPTIST3(UpdatePssPTIST3Command command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePssPTIST3Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PssPTIST3 - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePssPTIST3Command
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePssPTIST3Command command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePssPTIST3Command and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete PssPTIST3 using Id = " + command.getPssPTIST3Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PssPTIST3 via PssPTIST3FetchOneSummary
   *
   * @param summary PssPTIST3FetchOneSummary
   * @return PssPTIST3FetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PssPTIST3 getPssPTIST3(PssPTIST3FetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("PssPTIST3FetchOneSummary arg cannot be null");

    PssPTIST3 entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PssPTIST3
      // --------------------------------------
      CompletableFuture<PssPTIST3> futureEntity =
          queryGateway.query(
              new FindPssPTIST3Query(new LoadPssPTIST3Filter(summary.getPssPTIST3Id())),
              ResponseTypes.instanceOf(PssPTIST3.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate PssPTIST3 with id " + summary.getPssPTIST3Id();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PssPTIST3s
   *
   * @return List<PssPTIST3>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PssPTIST3> getAllPssPTIST3() throws ProcessingException {
    List<PssPTIST3> list = null;

    try {
      CompletableFuture<List<PssPTIST3>> futureList =
          queryGateway.query(
              new FindAllPssPTIST3Query(), ResponseTypes.multipleInstancesOf(PssPTIST3.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PssPTIST3";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign A0 on PssPTIST3
   *
   * @param command AssignA0ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignA0(AssignA0ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign A0 on PssPTIST3
   *
   * @param command UnAssignA0FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignA0(UnAssignA0FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A0 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign A1 on PssPTIST3
   *
   * @param command AssignA1ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignA1(AssignA1ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign A1 on PssPTIST3
   *
   * @param command UnAssignA1FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignA1(UnAssignA1FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A1 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign A2 on PssPTIST3
   *
   * @param command AssignA2ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignA2(AssignA2ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign A2 on PssPTIST3
   *
   * @param command UnAssignA2FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignA2(UnAssignA2FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A2 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign A3 on PssPTIST3
   *
   * @param command AssignA3ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignA3(AssignA3ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign A3 on PssPTIST3
   *
   * @param command UnAssignA3FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignA3(UnAssignA3FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A3 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign A4 on PssPTIST3
   *
   * @param command AssignA4ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignA4(AssignA4ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign A4 on PssPTIST3
   *
   * @param command UnAssignA4FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignA4(UnAssignA4FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A4 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign A5 on PssPTIST3
   *
   * @param command AssignA5ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignA5(AssignA5ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign A5 on PssPTIST3
   *
   * @param command UnAssignA5FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignA5(UnAssignA5FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign A5 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Al on PssPTIST3
   *
   * @param command AssignAlToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignAl(AssignAlToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Al on PssPTIST3
   *
   * @param command UnAssignAlFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignAl(UnAssignAlFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Al on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Athres on PssPTIST3
   *
   * @param command AssignAthresToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignAthres(AssignAthresToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Athres on PssPTIST3
   *
   * @param command UnAssignAthresFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignAthres(UnAssignAthresFromPssPTIST3Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Athres on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign B0 on PssPTIST3
   *
   * @param command AssignB0ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignB0(AssignB0ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign B0 on PssPTIST3
   *
   * @param command UnAssignB0FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignB0(UnAssignB0FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B0 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign B1 on PssPTIST3
   *
   * @param command AssignB1ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignB1(AssignB1ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign B1 on PssPTIST3
   *
   * @param command UnAssignB1FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignB1(UnAssignB1FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B1 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign B2 on PssPTIST3
   *
   * @param command AssignB2ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignB2(AssignB2ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign B2 on PssPTIST3
   *
   * @param command UnAssignB2FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignB2(UnAssignB2FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B2 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign B3 on PssPTIST3
   *
   * @param command AssignB3ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignB3(AssignB3ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign B3 on PssPTIST3
   *
   * @param command UnAssignB3FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignB3(UnAssignB3FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B3 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign B4 on PssPTIST3
   *
   * @param command AssignB4ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignB4(AssignB4ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign B4 on PssPTIST3
   *
   * @param command UnAssignB4FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignB4(UnAssignB4FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B4 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign B5 on PssPTIST3
   *
   * @param command AssignB5ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignB5(AssignB5ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign B5 on PssPTIST3
   *
   * @param command UnAssignB5FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignB5(UnAssignB5FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B5 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Dl on PssPTIST3
   *
   * @param command AssignDlToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignDl(AssignDlToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Dl on PssPTIST3
   *
   * @param command UnAssignDlFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignDl(UnAssignDlFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dl on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Dtc on PssPTIST3
   *
   * @param command AssignDtcToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignDtc(AssignDtcToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Dtc on PssPTIST3
   *
   * @param command UnAssignDtcFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignDtc(UnAssignDtcFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dtc on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Dtf on PssPTIST3
   *
   * @param command AssignDtfToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignDtf(AssignDtfToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Dtf on PssPTIST3
   *
   * @param command UnAssignDtfFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignDtf(UnAssignDtfFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dtf on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Dtp on PssPTIST3
   *
   * @param command AssignDtpToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignDtp(AssignDtpToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Dtp on PssPTIST3
   *
   * @param command UnAssignDtpFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignDtp(UnAssignDtpFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dtp on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Isw on PssPTIST3
   *
   * @param command AssignIswToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignIsw(AssignIswToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Isw on PssPTIST3
   *
   * @param command UnAssignIswFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignIsw(UnAssignIswFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Isw on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign K on PssPTIST3
   *
   * @param command AssignKToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignK(AssignKToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign K on PssPTIST3
   *
   * @param command UnAssignKFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignK(UnAssignKFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign K on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Lthres on PssPTIST3
   *
   * @param command AssignLthresToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignLthres(AssignLthresToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Lthres on PssPTIST3
   *
   * @param command UnAssignLthresFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignLthres(UnAssignLthresFromPssPTIST3Command command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Lthres on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign M on PssPTIST3
   *
   * @param command AssignMToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignM(AssignMToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign M on PssPTIST3
   *
   * @param command UnAssignMFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignM(UnAssignMFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign M on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Nav on PssPTIST3
   *
   * @param command AssignNavToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignNav(AssignNavToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Nav on PssPTIST3
   *
   * @param command UnAssignNavFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignNav(UnAssignNavFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Nav on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ncl on PssPTIST3
   *
   * @param command AssignNclToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignNcl(AssignNclToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Ncl on PssPTIST3
   *
   * @param command UnAssignNclFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignNcl(UnAssignNclFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ncl on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ncr on PssPTIST3
   *
   * @param command AssignNcrToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignNcr(AssignNcrToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Ncr on PssPTIST3
   *
   * @param command UnAssignNcrFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignNcr(UnAssignNcrFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ncr on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pmin on PssPTIST3
   *
   * @param command AssignPminToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignPmin(AssignPminToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Pmin on PssPTIST3
   *
   * @param command UnAssignPminFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignPmin(UnAssignPminFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pmin on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T1 on PssPTIST3
   *
   * @param command AssignT1ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignT1(AssignT1ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign T1 on PssPTIST3
   *
   * @param command UnAssignT1FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignT1(UnAssignT1FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T1 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T2 on PssPTIST3
   *
   * @param command AssignT2ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignT2(AssignT2ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign T2 on PssPTIST3
   *
   * @param command UnAssignT2FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignT2(UnAssignT2FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T2 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T3 on PssPTIST3
   *
   * @param command AssignT3ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignT3(AssignT3ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign T3 on PssPTIST3
   *
   * @param command UnAssignT3FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignT3(UnAssignT3FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T3 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T4 on PssPTIST3
   *
   * @param command AssignT4ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignT4(AssignT4ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign T4 on PssPTIST3
   *
   * @param command UnAssignT4FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignT4(UnAssignT4FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T4 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T5 on PssPTIST3
   *
   * @param command AssignT5ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignT5(AssignT5ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign T5 on PssPTIST3
   *
   * @param command UnAssignT5FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignT5(UnAssignT5FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T5 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T6 on PssPTIST3
   *
   * @param command AssignT6ToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignT6(AssignT6ToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign T6 on PssPTIST3
   *
   * @param command UnAssignT6FromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignT6(UnAssignT6FromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T6 on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tf on PssPTIST3
   *
   * @param command AssignTfToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignTf(AssignTfToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Tf on PssPTIST3
   *
   * @param command UnAssignTfFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignTf(UnAssignTfFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tf on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tp on PssPTIST3
   *
   * @param command AssignTpToPssPTIST3Command
   * @exception ProcessingException
   */
  public void assignTp(AssignTpToPssPTIST3Command command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPssPTIST3Id());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    PssPTIST3BusinessDelegate parentDelegate = PssPTIST3BusinessDelegate.getPssPTIST3Instance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

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
   * unAssign Tp on PssPTIST3
   *
   * @param command UnAssignTpFromPssPTIST3Command
   * @exception ProcessingException
   */
  public void unAssignTp(UnAssignTpFromPssPTIST3Command command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PssPTIST3Validator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tp on PssPTIST3";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PssPTIST3
   */
  private PssPTIST3 load(UUID id) throws ProcessingException {
    pssPTIST3 =
        PssPTIST3BusinessDelegate.getPssPTIST3Instance()
            .getPssPTIST3(new PssPTIST3FetchOneSummary(id));
    return pssPTIST3;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PssPTIST3 pssPTIST3 = null;
  private static final Logger LOGGER = Logger.getLogger(PssPTIST3BusinessDelegate.class.getName());
}
