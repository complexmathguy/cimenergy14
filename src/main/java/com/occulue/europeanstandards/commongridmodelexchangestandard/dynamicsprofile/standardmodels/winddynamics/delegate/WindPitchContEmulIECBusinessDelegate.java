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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator.*;
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
 * WindPitchContEmulIEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindPitchContEmulIEC related services in the case of a
 *       WindPitchContEmulIEC business related service failing.
 *   <li>Exposes a simpler, uniform WindPitchContEmulIEC interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindPitchContEmulIEC
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindPitchContEmulIECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindPitchContEmulIECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindPitchContEmulIEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindPitchContEmulIECBusinessDelegate
   */
  public static WindPitchContEmulIECBusinessDelegate getWindPitchContEmulIECInstance() {
    return (new WindPitchContEmulIECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindPitchContEmulIEC(
      CreateWindPitchContEmulIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindPitchContEmulIECId() == null)
        command.setWindPitchContEmulIECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindPitchContEmulIECCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindPitchContEmulIECCommand of WindPitchContEmulIEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindPitchContEmulIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindPitchContEmulIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindPitchContEmulIEC(
      UpdateWindPitchContEmulIECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindPitchContEmulIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindPitchContEmulIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindPitchContEmulIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindPitchContEmulIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindPitchContEmulIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindPitchContEmulIEC using Id = " + command.getWindPitchContEmulIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindPitchContEmulIEC via WindPitchContEmulIECFetchOneSummary
   *
   * @param summary WindPitchContEmulIECFetchOneSummary
   * @return WindPitchContEmulIECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindPitchContEmulIEC getWindPitchContEmulIEC(WindPitchContEmulIECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("WindPitchContEmulIECFetchOneSummary arg cannot be null");

    WindPitchContEmulIEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindPitchContEmulIEC
      // --------------------------------------
      CompletableFuture<WindPitchContEmulIEC> futureEntity =
          queryGateway.query(
              new FindWindPitchContEmulIECQuery(
                  new LoadWindPitchContEmulIECFilter(summary.getWindPitchContEmulIECId())),
              ResponseTypes.instanceOf(WindPitchContEmulIEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindPitchContEmulIEC with id " + summary.getWindPitchContEmulIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindPitchContEmulIECs
   *
   * @return List<WindPitchContEmulIEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindPitchContEmulIEC> getAllWindPitchContEmulIEC() throws ProcessingException {
    List<WindPitchContEmulIEC> list = null;

    try {
      CompletableFuture<List<WindPitchContEmulIEC>> futureList =
          queryGateway.query(
              new FindAllWindPitchContEmulIECQuery(),
              ResponseTypes.multipleInstancesOf(WindPitchContEmulIEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindPitchContEmulIEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Kdroop on WindPitchContEmulIEC
   *
   * @param command AssignKdroopToWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void assignKdroop(AssignKdroopToWindPitchContEmulIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPitchContEmulIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindPitchContEmulIECBusinessDelegate parentDelegate =
        WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

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
   * unAssign Kdroop on WindPitchContEmulIEC
   *
   * @param command UnAssignKdroopFromWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void unAssignKdroop(UnAssignKdroopFromWindPitchContEmulIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kdroop on WindPitchContEmulIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kipce on WindPitchContEmulIEC
   *
   * @param command AssignKipceToWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void assignKipce(AssignKipceToWindPitchContEmulIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPitchContEmulIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindPitchContEmulIECBusinessDelegate parentDelegate =
        WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

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
   * unAssign Kipce on WindPitchContEmulIEC
   *
   * @param command UnAssignKipceFromWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void unAssignKipce(UnAssignKipceFromWindPitchContEmulIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kipce on WindPitchContEmulIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Komegaaero on WindPitchContEmulIEC
   *
   * @param command AssignKomegaaeroToWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void assignKomegaaero(AssignKomegaaeroToWindPitchContEmulIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPitchContEmulIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindPitchContEmulIECBusinessDelegate parentDelegate =
        WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

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
   * unAssign Komegaaero on WindPitchContEmulIEC
   *
   * @param command UnAssignKomegaaeroFromWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void unAssignKomegaaero(UnAssignKomegaaeroFromWindPitchContEmulIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Komegaaero on WindPitchContEmulIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kppce on WindPitchContEmulIEC
   *
   * @param command AssignKppceToWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void assignKppce(AssignKppceToWindPitchContEmulIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPitchContEmulIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindPitchContEmulIECBusinessDelegate parentDelegate =
        WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

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
   * unAssign Kppce on WindPitchContEmulIEC
   *
   * @param command UnAssignKppceFromWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void unAssignKppce(UnAssignKppceFromWindPitchContEmulIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kppce on WindPitchContEmulIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Omegaref on WindPitchContEmulIEC
   *
   * @param command AssignOmegarefToWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void assignOmegaref(AssignOmegarefToWindPitchContEmulIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPitchContEmulIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindPitchContEmulIECBusinessDelegate parentDelegate =
        WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

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
   * unAssign Omegaref on WindPitchContEmulIEC
   *
   * @param command UnAssignOmegarefFromWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void unAssignOmegaref(UnAssignOmegarefFromWindPitchContEmulIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Omegaref on WindPitchContEmulIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pimax on WindPitchContEmulIEC
   *
   * @param command AssignPimaxToWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void assignPimax(AssignPimaxToWindPitchContEmulIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPitchContEmulIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindPitchContEmulIECBusinessDelegate parentDelegate =
        WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

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
   * unAssign Pimax on WindPitchContEmulIEC
   *
   * @param command UnAssignPimaxFromWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void unAssignPimax(UnAssignPimaxFromWindPitchContEmulIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pimax on WindPitchContEmulIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Pimin on WindPitchContEmulIEC
   *
   * @param command AssignPiminToWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void assignPimin(AssignPiminToWindPitchContEmulIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPitchContEmulIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindPitchContEmulIECBusinessDelegate parentDelegate =
        WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

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
   * unAssign Pimin on WindPitchContEmulIEC
   *
   * @param command UnAssignPiminFromWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void unAssignPimin(UnAssignPiminFromWindPitchContEmulIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Pimin on WindPitchContEmulIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T1 on WindPitchContEmulIEC
   *
   * @param command AssignT1ToWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void assignT1(AssignT1ToWindPitchContEmulIECCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPitchContEmulIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindPitchContEmulIECBusinessDelegate parentDelegate =
        WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

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
   * unAssign T1 on WindPitchContEmulIEC
   *
   * @param command UnAssignT1FromWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void unAssignT1(UnAssignT1FromWindPitchContEmulIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T1 on WindPitchContEmulIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign T2 on WindPitchContEmulIEC
   *
   * @param command AssignT2ToWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void assignT2(AssignT2ToWindPitchContEmulIECCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPitchContEmulIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindPitchContEmulIECBusinessDelegate parentDelegate =
        WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

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
   * unAssign T2 on WindPitchContEmulIEC
   *
   * @param command UnAssignT2FromWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void unAssignT2(UnAssignT2FromWindPitchContEmulIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign T2 on WindPitchContEmulIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpe on WindPitchContEmulIEC
   *
   * @param command AssignTpeToWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void assignTpe(AssignTpeToWindPitchContEmulIECCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPitchContEmulIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindPitchContEmulIECBusinessDelegate parentDelegate =
        WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

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
   * unAssign Tpe on WindPitchContEmulIEC
   *
   * @param command UnAssignTpeFromWindPitchContEmulIECCommand
   * @exception ProcessingException
   */
  public void unAssignTpe(UnAssignTpeFromWindPitchContEmulIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPitchContEmulIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpe on WindPitchContEmulIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindPitchContEmulIEC
   */
  private WindPitchContEmulIEC load(UUID id) throws ProcessingException {
    windPitchContEmulIEC =
        WindPitchContEmulIECBusinessDelegate.getWindPitchContEmulIECInstance()
            .getWindPitchContEmulIEC(new WindPitchContEmulIECFetchOneSummary(id));
    return windPitchContEmulIEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindPitchContEmulIEC windPitchContEmulIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindPitchContEmulIECBusinessDelegate.class.getName());
}
