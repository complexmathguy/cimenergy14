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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.validator.*;
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
 * EquivalentBranch business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of EquivalentBranch related services in the case of a
 *       EquivalentBranch business related service failing.
 *   <li>Exposes a simpler, uniform EquivalentBranch interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill EquivalentBranch business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class EquivalentBranchBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public EquivalentBranchBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * EquivalentBranch Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return EquivalentBranchBusinessDelegate
   */
  public static EquivalentBranchBusinessDelegate getEquivalentBranchInstance() {
    return (new EquivalentBranchBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createEquivalentBranch(CreateEquivalentBranchCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getEquivalentBranchId() == null) command.setEquivalentBranchId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateEquivalentBranchCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateEquivalentBranchCommand of EquivalentBranch is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create EquivalentBranch - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateEquivalentBranchCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateEquivalentBranch(UpdateEquivalentBranchCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateEquivalentBranchCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save EquivalentBranch - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteEquivalentBranchCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteEquivalentBranchCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteEquivalentBranchCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete EquivalentBranch using Id = " + command.getEquivalentBranchId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the EquivalentBranch via EquivalentBranchFetchOneSummary
   *
   * @param summary EquivalentBranchFetchOneSummary
   * @return EquivalentBranchFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public EquivalentBranch getEquivalentBranch(EquivalentBranchFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("EquivalentBranchFetchOneSummary arg cannot be null");

    EquivalentBranch entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a EquivalentBranch
      // --------------------------------------
      CompletableFuture<EquivalentBranch> futureEntity =
          queryGateway.query(
              new FindEquivalentBranchQuery(
                  new LoadEquivalentBranchFilter(summary.getEquivalentBranchId())),
              ResponseTypes.instanceOf(EquivalentBranch.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate EquivalentBranch with id " + summary.getEquivalentBranchId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all EquivalentBranchs
   *
   * @return List<EquivalentBranch>
   * @exception ProcessingException Thrown if any problems
   */
  public List<EquivalentBranch> getAllEquivalentBranch() throws ProcessingException {
    List<EquivalentBranch> list = null;

    try {
      CompletableFuture<List<EquivalentBranch>> futureList =
          queryGateway.query(
              new FindAllEquivalentBranchQuery(),
              ResponseTypes.multipleInstancesOf(EquivalentBranch.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all EquivalentBranch";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign NegativeR12 on EquivalentBranch
   *
   * @param command AssignNegativeR12ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignNegativeR12(AssignNegativeR12ToEquivalentBranchCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign NegativeR12 on EquivalentBranch
   *
   * @param command UnAssignNegativeR12FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignNegativeR12(UnAssignNegativeR12FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NegativeR12 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NegativeR21 on EquivalentBranch
   *
   * @param command AssignNegativeR21ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignNegativeR21(AssignNegativeR21ToEquivalentBranchCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign NegativeR21 on EquivalentBranch
   *
   * @param command UnAssignNegativeR21FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignNegativeR21(UnAssignNegativeR21FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NegativeR21 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NegativeX12 on EquivalentBranch
   *
   * @param command AssignNegativeX12ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignNegativeX12(AssignNegativeX12ToEquivalentBranchCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign NegativeX12 on EquivalentBranch
   *
   * @param command UnAssignNegativeX12FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignNegativeX12(UnAssignNegativeX12FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NegativeX12 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NegativeX21 on EquivalentBranch
   *
   * @param command AssignNegativeX21ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignNegativeX21(AssignNegativeX21ToEquivalentBranchCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign NegativeX21 on EquivalentBranch
   *
   * @param command UnAssignNegativeX21FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignNegativeX21(UnAssignNegativeX21FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NegativeX21 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PositiveR12 on EquivalentBranch
   *
   * @param command AssignPositiveR12ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignPositiveR12(AssignPositiveR12ToEquivalentBranchCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign PositiveR12 on EquivalentBranch
   *
   * @param command UnAssignPositiveR12FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignPositiveR12(UnAssignPositiveR12FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PositiveR12 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PositiveR21 on EquivalentBranch
   *
   * @param command AssignPositiveR21ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignPositiveR21(AssignPositiveR21ToEquivalentBranchCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign PositiveR21 on EquivalentBranch
   *
   * @param command UnAssignPositiveR21FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignPositiveR21(UnAssignPositiveR21FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PositiveR21 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PositiveX12 on EquivalentBranch
   *
   * @param command AssignPositiveX12ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignPositiveX12(AssignPositiveX12ToEquivalentBranchCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign PositiveX12 on EquivalentBranch
   *
   * @param command UnAssignPositiveX12FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignPositiveX12(UnAssignPositiveX12FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PositiveX12 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign PositiveX21 on EquivalentBranch
   *
   * @param command AssignPositiveX21ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignPositiveX21(AssignPositiveX21ToEquivalentBranchCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign PositiveX21 on EquivalentBranch
   *
   * @param command UnAssignPositiveX21FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignPositiveX21(UnAssignPositiveX21FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PositiveX21 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R on EquivalentBranch
   *
   * @param command AssignRToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignR(AssignRToEquivalentBranchCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign R on EquivalentBranch
   *
   * @param command UnAssignRFromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignR(UnAssignRFromEquivalentBranchCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R21 on EquivalentBranch
   *
   * @param command AssignR21ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignR21(AssignR21ToEquivalentBranchCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign R21 on EquivalentBranch
   *
   * @param command UnAssignR21FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignR21(UnAssignR21FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R21 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X on EquivalentBranch
   *
   * @param command AssignXToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignX(AssignXToEquivalentBranchCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign X on EquivalentBranch
   *
   * @param command UnAssignXFromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignX(UnAssignXFromEquivalentBranchCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X21 on EquivalentBranch
   *
   * @param command AssignX21ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignX21(AssignX21ToEquivalentBranchCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign X21 on EquivalentBranch
   *
   * @param command UnAssignX21FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignX21(UnAssignX21FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X21 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ZeroR12 on EquivalentBranch
   *
   * @param command AssignZeroR12ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignZeroR12(AssignZeroR12ToEquivalentBranchCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign ZeroR12 on EquivalentBranch
   *
   * @param command UnAssignZeroR12FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignZeroR12(UnAssignZeroR12FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ZeroR12 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ZeroR21 on EquivalentBranch
   *
   * @param command AssignZeroR21ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignZeroR21(AssignZeroR21ToEquivalentBranchCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ResistanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ResistanceBusinessDelegate.getResistanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getResistanceId();
    Resistance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign ZeroR21 on EquivalentBranch
   *
   * @param command UnAssignZeroR21FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignZeroR21(UnAssignZeroR21FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ZeroR21 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ZeroX12 on EquivalentBranch
   *
   * @param command AssignZeroX12ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignZeroX12(AssignZeroX12ToEquivalentBranchCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign ZeroX12 on EquivalentBranch
   *
   * @param command UnAssignZeroX12FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignZeroX12(UnAssignZeroX12FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ZeroX12 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ZeroX21 on EquivalentBranch
   *
   * @param command AssignZeroX21ToEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void assignZeroX21(AssignZeroX21ToEquivalentBranchCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquivalentBranchId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactanceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactanceBusinessDelegate.getReactanceInstance();
    EquivalentBranchBusinessDelegate parentDelegate =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();
    UUID childId = command.getAssignment().getReactanceId();
    Reactance child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

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
   * unAssign ZeroX21 on EquivalentBranch
   *
   * @param command UnAssignZeroX21FromEquivalentBranchCommand
   * @exception ProcessingException
   */
  public void unAssignZeroX21(UnAssignZeroX21FromEquivalentBranchCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquivalentBranchValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ZeroX21 on EquivalentBranch";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return EquivalentBranch
   */
  private EquivalentBranch load(UUID id) throws ProcessingException {
    equivalentBranch =
        EquivalentBranchBusinessDelegate.getEquivalentBranchInstance()
            .getEquivalentBranch(new EquivalentBranchFetchOneSummary(id));
    return equivalentBranch;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private EquivalentBranch equivalentBranch = null;
  private static final Logger LOGGER =
      Logger.getLogger(EquivalentBranchBusinessDelegate.class.getName());
}
