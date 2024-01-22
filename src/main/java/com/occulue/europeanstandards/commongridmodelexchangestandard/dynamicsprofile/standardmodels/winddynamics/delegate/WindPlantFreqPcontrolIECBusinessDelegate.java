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
 * WindPlantFreqPcontrolIEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindPlantFreqPcontrolIEC related services in the case of a
 *       WindPlantFreqPcontrolIEC business related service failing.
 *   <li>Exposes a simpler, uniform WindPlantFreqPcontrolIEC interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindPlantFreqPcontrolIEC
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindPlantFreqPcontrolIECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindPlantFreqPcontrolIECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindPlantFreqPcontrolIEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindPlantFreqPcontrolIECBusinessDelegate
   */
  public static WindPlantFreqPcontrolIECBusinessDelegate getWindPlantFreqPcontrolIECInstance() {
    return (new WindPlantFreqPcontrolIECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindPlantFreqPcontrolIEC(
      CreateWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindPlantFreqPcontrolIECId() == null)
        command.setWindPlantFreqPcontrolIECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindPlantFreqPcontrolIECCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindPlantFreqPcontrolIECCommand of WindPlantFreqPcontrolIEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindPlantFreqPcontrolIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindPlantFreqPcontrolIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindPlantFreqPcontrolIEC(
      UpdateWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindPlantFreqPcontrolIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindPlantFreqPcontrolIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindPlantFreqPcontrolIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindPlantFreqPcontrolIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindPlantFreqPcontrolIEC using Id = "
              + command.getWindPlantFreqPcontrolIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindPlantFreqPcontrolIEC via WindPlantFreqPcontrolIECFetchOneSummary
   *
   * @param summary WindPlantFreqPcontrolIECFetchOneSummary
   * @return WindPlantFreqPcontrolIECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindPlantFreqPcontrolIEC getWindPlantFreqPcontrolIEC(
      WindPlantFreqPcontrolIECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "WindPlantFreqPcontrolIECFetchOneSummary arg cannot be null");

    WindPlantFreqPcontrolIEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindPlantFreqPcontrolIEC
      // --------------------------------------
      CompletableFuture<WindPlantFreqPcontrolIEC> futureEntity =
          queryGateway.query(
              new FindWindPlantFreqPcontrolIECQuery(
                  new LoadWindPlantFreqPcontrolIECFilter(summary.getWindPlantFreqPcontrolIECId())),
              ResponseTypes.instanceOf(WindPlantFreqPcontrolIEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindPlantFreqPcontrolIEC with id "
              + summary.getWindPlantFreqPcontrolIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindPlantFreqPcontrolIECs
   *
   * @return List<WindPlantFreqPcontrolIEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindPlantFreqPcontrolIEC> getAllWindPlantFreqPcontrolIEC()
      throws ProcessingException {
    List<WindPlantFreqPcontrolIEC> list = null;

    try {
      CompletableFuture<List<WindPlantFreqPcontrolIEC>> futureList =
          queryGateway.query(
              new FindAllWindPlantFreqPcontrolIECQuery(),
              ResponseTypes.multipleInstancesOf(WindPlantFreqPcontrolIEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindPlantFreqPcontrolIEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Dprefmax on WindPlantFreqPcontrolIEC
   *
   * @param command AssignDprefmaxToWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void assignDprefmax(AssignDprefmaxToWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantFreqPcontrolIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindPlantFreqPcontrolIECBusinessDelegate parentDelegate =
        WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

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
   * unAssign Dprefmax on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignDprefmaxFromWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void unAssignDprefmax(UnAssignDprefmaxFromWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dprefmax on WindPlantFreqPcontrolIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Dprefmin on WindPlantFreqPcontrolIEC
   *
   * @param command AssignDprefminToWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void assignDprefmin(AssignDprefminToWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantFreqPcontrolIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindPlantFreqPcontrolIECBusinessDelegate parentDelegate =
        WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

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
   * unAssign Dprefmin on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignDprefminFromWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void unAssignDprefmin(UnAssignDprefminFromWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Dprefmin on WindPlantFreqPcontrolIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kiwpp on WindPlantFreqPcontrolIEC
   *
   * @param command AssignKiwppToWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void assignKiwpp(AssignKiwppToWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantFreqPcontrolIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindPlantFreqPcontrolIECBusinessDelegate parentDelegate =
        WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

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
   * unAssign Kiwpp on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignKiwppFromWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void unAssignKiwpp(UnAssignKiwppFromWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kiwpp on WindPlantFreqPcontrolIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpwpp on WindPlantFreqPcontrolIEC
   *
   * @param command AssignKpwppToWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void assignKpwpp(AssignKpwppToWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantFreqPcontrolIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindPlantFreqPcontrolIECBusinessDelegate parentDelegate =
        WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

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
   * unAssign Kpwpp on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignKpwppFromWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void unAssignKpwpp(UnAssignKpwppFromWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpwpp on WindPlantFreqPcontrolIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Prefmax on WindPlantFreqPcontrolIEC
   *
   * @param command AssignPrefmaxToWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void assignPrefmax(AssignPrefmaxToWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantFreqPcontrolIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindPlantFreqPcontrolIECBusinessDelegate parentDelegate =
        WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

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
   * unAssign Prefmax on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignPrefmaxFromWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void unAssignPrefmax(UnAssignPrefmaxFromWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Prefmax on WindPlantFreqPcontrolIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Prefmin on WindPlantFreqPcontrolIEC
   *
   * @param command AssignPrefminToWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void assignPrefmin(AssignPrefminToWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantFreqPcontrolIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindPlantFreqPcontrolIECBusinessDelegate parentDelegate =
        WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

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
   * unAssign Prefmin on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignPrefminFromWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void unAssignPrefmin(UnAssignPrefminFromWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Prefmin on WindPlantFreqPcontrolIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpft on WindPlantFreqPcontrolIEC
   *
   * @param command AssignTpftToWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void assignTpft(AssignTpftToWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantFreqPcontrolIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindPlantFreqPcontrolIECBusinessDelegate parentDelegate =
        WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

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
   * unAssign Tpft on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignTpftFromWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void unAssignTpft(UnAssignTpftFromWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpft on WindPlantFreqPcontrolIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpfv on WindPlantFreqPcontrolIEC
   *
   * @param command AssignTpfvToWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void assignTpfv(AssignTpfvToWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantFreqPcontrolIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindPlantFreqPcontrolIECBusinessDelegate parentDelegate =
        WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

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
   * unAssign Tpfv on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignTpfvFromWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void unAssignTpfv(UnAssignTpfvFromWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpfv on WindPlantFreqPcontrolIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Twpffilt on WindPlantFreqPcontrolIEC
   *
   * @param command AssignTwpffiltToWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void assignTwpffilt(AssignTwpffiltToWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantFreqPcontrolIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindPlantFreqPcontrolIECBusinessDelegate parentDelegate =
        WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

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
   * unAssign Twpffilt on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignTwpffiltFromWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void unAssignTwpffilt(UnAssignTwpffiltFromWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Twpffilt on WindPlantFreqPcontrolIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Twppfilt on WindPlantFreqPcontrolIEC
   *
   * @param command AssignTwppfiltToWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void assignTwppfilt(AssignTwppfiltToWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantFreqPcontrolIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindPlantFreqPcontrolIECBusinessDelegate parentDelegate =
        WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

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
   * unAssign Twppfilt on WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignTwppfiltFromWindPlantFreqPcontrolIECCommand
   * @exception ProcessingException
   */
  public void unAssignTwppfilt(UnAssignTwppfiltFromWindPlantFreqPcontrolIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantFreqPcontrolIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Twppfilt on WindPlantFreqPcontrolIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindPlantFreqPcontrolIEC
   */
  private WindPlantFreqPcontrolIEC load(UUID id) throws ProcessingException {
    windPlantFreqPcontrolIEC =
        WindPlantFreqPcontrolIECBusinessDelegate.getWindPlantFreqPcontrolIECInstance()
            .getWindPlantFreqPcontrolIEC(new WindPlantFreqPcontrolIECFetchOneSummary(id));
    return windPlantFreqPcontrolIEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindPlantFreqPcontrolIEC windPlantFreqPcontrolIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindPlantFreqPcontrolIECBusinessDelegate.class.getName());
}
